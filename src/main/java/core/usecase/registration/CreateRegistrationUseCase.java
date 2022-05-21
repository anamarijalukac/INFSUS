package core.usecase.registration;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import core.usecase.UseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.user.UserRepository;
import lombok.Value;

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

        User user = userRepo.findById(input.getUserId());
        Orchestra orchestra = orchestraRepository.getById(input.getOrchestraId());

        Registration registration = new Registration();

        registration.setDate(input.getDate());
        registration.setId(input.getRegistrationId());
        registration.setOrchestra(orchestra);
        registration.setUser(user);

        registrationRepository.save(registration);
        user.getRegistrationList().add(registration);
        userRepo.save(user);
        orchestra.getRegistrations().add(registration);
        orchestraRepository.save(orchestra);

        return new CreateRegistrationUseCase.OutputValues(registration);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long userId;
        Date date;
        Long orchestraId;
        Long registrationId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Registration registration;
    }
}
