package core.usecase.orchestra;

import core.domain.NotFoundException;
import core.domain.Orchestra;
import core.usecase.UseCase;
import lombok.Value;

public class GetOrchestraUseCase extends UseCase<GetOrchestraUseCase.InputValues, GetOrchestraUseCase.OutputValues> {

    private final OrchestraRepository repository;

    public GetOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        final Long id = input.getOrchestraId();

        Orchestra orchestra = repository.getById(id);

        if (orchestra == null) {
            throw new NotFoundException("Orchestra " + id + " not found");
        }

        return new OutputValues(orchestra);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long orchestraId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Orchestra orchestra;
    }
}
