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
public class SignUpRequest implements JavaDelegate {

    private final OrchestraRepository orchestraRepository;

    public SignUpRequest(OrchestraRepository orchestraRepository) {
        this.orchestraRepository = orchestraRepository;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long userId = (Long) execution.getVariable("userId");
        Long orchestraId = (Long) execution.getVariable("orchestraId");
        System.out.println("Started process for user(" + userId + ") and orchestra(" + orchestraId + ")");
        String alreadyIn = "YES";
        if (!isAlreadyIn(userId)) {
            alreadyIn = "NO";
        }
        System.out.println("User is already in? " + alreadyIn);
        execution.setVariable("alreadyIn", alreadyIn);
    }

    private boolean isAlreadyIn(Long userId) {
        List<Orchestra> orchestras = orchestraRepository.getAll();
        for (Orchestra orchestra : orchestras) {
            Optional<User> exists = orchestra.getMembers().stream().filter(user -> Objects.equals(user.getId(), userId)).findFirst();
            if (exists.isPresent()) {
                return true;
            }
        }
        return false;
    }
}

