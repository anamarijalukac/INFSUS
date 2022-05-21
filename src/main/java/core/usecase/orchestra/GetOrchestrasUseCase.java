package core.usecase.orchestra;

import core.domain.Orchestra;
import core.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class GetOrchestrasUseCase extends UseCase<GetOrchestrasUseCase.InputValues, GetOrchestrasUseCase.OutputValues> {

    private final OrchestraRepository repository;

    public GetOrchestrasUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(repository.getAll());
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<Orchestra> orchestras;
    }
}
