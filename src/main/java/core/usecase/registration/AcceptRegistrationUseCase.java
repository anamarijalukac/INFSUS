package core.usecase.registration;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import core.usecase.UseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.user.UserRepository;

import java.util.Date;

public class AcceptRegistrationUseCase extends UseCase<AcceptRegistrationUseCase.InputValues, AcceptRegistrationUseCase.OutputValues> {

    private final RegistrationRepository registrationRepo;
    private final UserRepository userRepo;
    private final OrchestraRepository orchestraRepo;

    public AcceptRegistrationUseCase(RegistrationRepository registrationRepo, UserRepository userRepo, OrchestraRepository orchestraRepo) {
        this.registrationRepo = registrationRepo;
        this.userRepo = userRepo;
        this.orchestraRepo = orchestraRepo;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (!registrationRepo.existsByUserAndOrchestra(input.getUser(), input.getOrchestra())) {
            throw new Exception("Registration does not exist!");
        }

        Registration registration=registrationRepo.findByUserAndOrchestra(input.getUser(),input.getOrchestra());
        registration.setAcceptedStatus(true);
        //userRepo.addOrchestra(input.getUser(),input.getOrchestra());
        //orchestraRepo.addMember(input.getUser());

        return new AcceptRegistrationUseCase.OutputValues(registration);




    }

    public static class InputValues implements UseCase.InputValues {
        private final User user;
        private final Orchestra orchestra;

        public InputValues(User user, Orchestra orchestra, Date date) {
            this.user = user;
            this.orchestra = orchestra;


        }

        public User getUser() {
            return user;
        }

        public Orchestra getOrchestra() {
            return orchestra;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Registration registration;

        public OutputValues(Registration registration) {
            this.registration = registration;
        }
    }
}
