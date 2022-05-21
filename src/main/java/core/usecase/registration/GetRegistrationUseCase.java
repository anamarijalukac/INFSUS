package core.usecase.registration;

import core.domain.NotFoundException;
import core.domain.Registration;
import core.usecase.UseCase;
import lombok.Value;

public class GetRegistrationUseCase extends UseCase<GetRegistrationUseCase.InputValues, GetRegistrationUseCase.OutputValues> {

    private final RegistrationRepository repository;

    public GetRegistrationUseCase(RegistrationRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        final Long id = input.getRegistrationId();

        Registration registration = repository.findById(id);

        if (registration == null) {
            throw new NotFoundException("Registration " + id + " not found");
        }

        return new OutputValues(registration);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long registrationId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Registration registration;
    }
}
