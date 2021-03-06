package core.usecase.orchestra;

import core.domain.AlreadyExistsException;
import core.domain.Discography;
import core.domain.Orchestra;
import core.domain.User;
import core.usecase.UseCase;
import lombok.Value;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

public class CreateOrchestraUseCase extends UseCase<CreateOrchestraUseCase.InputValues, CreateOrchestraUseCase.OutputValues> {

    private final OrchestraRepository repository;

    public CreateOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Orchestra orchestra = new Orchestra();
        orchestra.setName(input.getName());
        orchestra.setFounded_date(input.getFounded_date());
        orchestra.setId(input.getOrchestraId());
        orchestra.setMembers(getMembers(input.getMembers()));
        orchestra.setWeb_page(input.getWeb_page());

        Discography discography = new Discography();
        orchestra.setDiscography(discography);
        if (input.getLeader() != null) {
            User leader = mapUserInput(input.getLeader());
            leader.setStatus("LEADER");
            orchestra.setLeader(leader);
        }
        repository.save(orchestra);


        return new CreateOrchestraUseCase.OutputValues(orchestra);
    }

    private List<User> getMembers(List<UserInput> users) {
        return emptyIfNull(users).stream().map(this::mapUserInput).collect(Collectors.toList());
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
