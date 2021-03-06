package camunda;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import core.service.EmailService;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.user.UserRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;

import javax.inject.Named;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Named
public class SendInformation implements JavaDelegate {

    private final UserRepository userRepository;
    private final OrchestraRepository orchestraRepository;
    private final EmailService emailService;

    public SendInformation(UserRepository userRepository, OrchestraRepository orchestraRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.orchestraRepository = orchestraRepository;
        this.emailService = emailService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long userId = (Long) execution.getVariable("userId");
        Long orchestraId = (Long) execution.getVariable("orchestraId");
        System.out.println("Alerting orchestra leader for user(" + userId + ") and orchestra(" + orchestraId + ")");
        Orchestra orchestra = orchestraRepository.getById(orchestraId);
        User user = userRepository.findById(userId);
        User leader = orchestra.getLeader();
        if (leader != null) {
            String email = leader.getEmail();
            String subject = "New request for joining your orchestra!";
            String text = "User " + user.getName() + " wants to join your orchestra. Approve him in application.";
            emailService.sendSimpleMessage(email, subject, text);
            System.out.println("Mail sent.");
        }
        orchestra.addRegistration(createRegistration(user, orchestra));
        orchestraRepository.save(orchestra);
    }

    private Registration createRegistration(User user, Orchestra orchestra) {
        Registration registration = new Registration();
        registration.setOrchestra(orchestra);
        registration.setUser(user);
        registration.setDate(new Date());
        return registration;
    }
}

