package core.usecase.registration;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import core.usecase.UseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.user.CreateUserUseCase;
import core.usecase.user.UserRepository;

import java.util.Date;

public class CreateRegistrationUseCase extends UseCase<CreateRegistrationUseCase.InputValues, CreateRegistrationUseCase.OutputValues> {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepo;
    private final OrchestraRepository orchestraRepository;

    public CreateRegistrationUseCase(RegistrationRepository registrationRepository, UserRepository userRepo, OrchestraRepository orchestraRepository) {
        this.registrationRepository = registrationRepository;
        this.userRepo = userRepo;
        this.orchestraRepository = orchestraRepository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (registrationRepository.existsById(input.getRegistrationId())) {
            throw new Exception("Registration already exists!");
        }



        User user=userRepo.findById(input.getUserId());
        Orchestra orchestra=orchestraRepository.getById(input.getOrchestraId());

        Registration registration = new Registration(
               user,orchestra,
                input.getDate(), input.getRegistrationId()
        );

        registrationRepository.save(registration);
        user.getRegistrationList().add(registration);
        userRepo.save(user);
        orchestra.getRegistrations().add(registration);
        orchestraRepository.save(orchestra);

        return new CreateRegistrationUseCase.OutputValues(registration);


    }


    public static class InputValues implements UseCase.InputValues {
        private final Long userId;
        private final Date date;
        private final Long orchestraId;
        private final Long registrationId;

        public InputValues(Long userId, Date date, Long orchestraId, Long registrationId) {
            this.userId = userId;
            this.date = date;
            this.orchestraId = orchestraId;
            this.registrationId = registrationId;
        }

        public Long getUserId() {
            return userId;
        }

        public Date getDate() {
            return date;
        }

        public Long getOrchestraId() {
            return orchestraId;
        }

        public Long getRegistrationId() {
            return registrationId;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Registration registration;

        public OutputValues(Registration registration) {
            this.registration = registration;
        }
    }


}
