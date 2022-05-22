package core.usecase.orchestra;

import core.domain.*;
import core.usecase.UseCase;
import lombok.Value;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateOrchestraUseCase extends UseCase<UpdateOrchestraUseCase.InputValues, UpdateOrchestraUseCase.OutputValues> {

    private final OrchestraRepository repository;


    public UpdateOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Orchestra orchestra = repository.getById(input.getOrchestraId());
        if (input.getName() != null)
            orchestra.setName(input.getName());

        if (input.getFounded_date() != null)
            orchestra.setFounded_date(input.getFounded_date());

        if (input.getMembers() != null)
            orchestra.setMembers(input.getMembers().stream().map(this::mapUserInput).collect(Collectors.toList()));

        if (input.getLeader() != null)
            orchestra.setLeader(mapUserInput(input.getLeader()));

        if (input.getWeb_page() != null)
            orchestra.setWeb_page(input.getWeb_page());

        repository.save(orchestra);

        return new UpdateOrchestraUseCase.OutputValues(orchestra);
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
        String web_page;
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
