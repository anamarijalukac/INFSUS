package core.usecase.registration;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import core.usecase.UseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.user.UserRepository;
import lombok.Value;

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
        if (!registrationRepo.existsById(input.getRegistrationId())) {
            throw new Exception("Registration does not exist!");
        }

        Registration registration = registrationRepo.findById(input.getRegistrationId());
        User user = userRepo.findById(input.getUserId());
        Orchestra orchestra = orchestraRepo.getById(input.getOrchestraId());

        registration.setAcceptedStatus(true);
        user.setOrchestra(orchestra);
        orchestra.getMembers().add(user);

        userRepo.save(user);
        orchestraRepo.save(orchestra);
        registrationRepo.save(registration);

        return new AcceptRegistrationUseCase.OutputValues(registration);


    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        User user;
        Orchestra orchestra;
        Long registrationId;
        Long userId;
        Long orchestraId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Registration registration;
    }
}
