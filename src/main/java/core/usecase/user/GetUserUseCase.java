package core.usecase.user;

import core.domain.User;
import core.usecase.UseCase;
import lombok.Value;

public class GetUserUseCase extends UseCase<GetUserUseCase.InputValues, GetUserUseCase.OutputValues> {

    private final UserRepository repository;

    public GetUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        final Long id = input.getUserId();

        User user = repository.findById(id);

        if (user == null) {
            throw new Exception("User " + id + " not found");
        }

        return new OutputValues(user);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long userId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        User user;
    }
}
