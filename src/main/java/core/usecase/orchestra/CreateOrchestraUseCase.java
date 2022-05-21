package core.usecase.orchestra;

import core.domain.AlreadyExistsException;
import core.domain.Orchestra;
import core.domain.User;
import core.usecase.UseCase;
import lombok.Value;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CreateOrchestraUseCase extends UseCase<CreateOrchestraUseCase.InputValues, CreateOrchestraUseCase.OutputValues> {

    private final OrchestraRepository repository;

    public CreateOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        if (repository.existsById(input.getOrchestraId())) {
            throw new AlreadyExistsException("Orchestra name already in use!");
        }

        Orchestra orchestra = new Orchestra();
        orchestra.setName(input.getName());
        orchestra.setFounded_date(input.getFounded_date());
        orchestra.setId(input.getOrchestraId());
        orchestra.setMembers(getMembers(input.getMembers()));

        User leader = mapUserInput(input.getLeader());
        leader.setStatus("LEADER");
        orchestra.setLeader(leader);

        repository.save(orchestra);


        return new CreateOrchestraUseCase.OutputValues(orchestra);
    }

    private List<User> getMembers(List<UserInput> users) {
        return users.stream().map(this::mapUserInput).collect(Collectors.toList());
    }

    private User mapUserInput(UserInput userInput) {
        User user = new User();
        user.setId(userInput.getId());
        user.setName(userInput.getName());
        user.setEmail(userInput.getEmail());
        return user;
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String name;
        Date founded_date;
        List<UserInput> members;
        UserInput leader;
        Long orchestraId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Orchestra orchestra;
    }

    @Value
    public static class UserInput {
        Long id;
        String name;
        String email;
    }
}
