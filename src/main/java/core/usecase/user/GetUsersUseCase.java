package core.usecase.user;

import core.domain.User;
import core.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class GetUsersUseCase extends UseCase<GetUsersUseCase.InputValues, GetUsersUseCase.OutputValues> {

    private final UserRepository repository;

    public GetUsersUseCase(UserRepository repository) {
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
        List<User> users;
    }
}
