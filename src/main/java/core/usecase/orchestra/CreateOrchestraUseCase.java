package core.usecase.orchestra;

import core.domain.Orchestra;
import core.domain.User;
import core.usecase.UseCase;
import lombok.Value;

import java.util.Date;
import java.util.List;

public class CreateOrchestraUseCase extends UseCase<CreateOrchestraUseCase.InputValues, CreateOrchestraUseCase.OutputValues> {

    private final OrchestraRepository repository;

    public CreateOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (repository.existsById(input.getOrchestraId())) {
            throw new Exception("Orchestra name already in use!");
        }

        Orchestra orchestra = new Orchestra();
        orchestra.setName(input.getName());
        orchestra.setFounded_date(input.getFounded_date());
        orchestra.setId(input.getOrchestraId());
        orchestra.setMembers(input.getMembers());
        orchestra.setLeader(input.getLeader());

        input.getLeader().setStatus("LEADER");

        repository.save(orchestra);


        return new CreateOrchestraUseCase.OutputValues(orchestra);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String name;
        Date founded_date;
        List<User> members;
        User leader;
        Long orchestraId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Orchestra orchestra;
    }

}
