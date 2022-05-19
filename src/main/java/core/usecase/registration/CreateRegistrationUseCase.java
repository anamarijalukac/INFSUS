package core.usecase.registration;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import core.usecase.UseCase;
import core.usecase.user.CreateUserUseCase;
import core.usecase.user.UserRepository;

import java.util.Date;

public class CreateRegistrationUseCase extends UseCase<CreateRegistrationUseCase.InputValues, CreateRegistrationUseCase.OutputValues> {

    private final RegistrationRepository repository;
    private final UserRepository userRepo;

    public CreateRegistrationUseCase(RegistrationRepository repository, UserRepository userRepo) {
        this.repository = repository;
        this.userRepo = userRepo;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (repository.existsByUserAndOrchestra(input.getUser(), input.getOrchestra())) {
            throw new Exception("Registration already exists!");
        }

        if (repository.ifUserIsMember(input.getUser(), input.getOrchestra())) {
            throw new Exception("This user is already a member!");
        }

        Registration registration = new Registration(
                input.getUser(),
                input.getOrchestra(),
                input.getDate()
        );

        //userRepo.addRegistration( input.getUser(),registration);

        return new CreateRegistrationUseCase.OutputValues(registration);


    }


    public static class InputValues implements UseCase.InputValues {
        private final User user;
        private final Orchestra orchestra;
        private final Date date;

        public InputValues(User user, Orchestra orchestra, Date date) {
            this.user = user;
            this.orchestra = orchestra;
            this.date = date;

        }

        public Date getDate() {
            return date;
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
