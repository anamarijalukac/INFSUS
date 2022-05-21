package core.usecase.user;

import core.domain.User;
import core.usecase.UseCase;
import lombok.Value;

public class CreateUserUseCase extends UseCase<CreateUserUseCase.InputValues, CreateUserUseCase.OutputValues> {

    private final UserRepository repository;

    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (repository.existsById(input.getUserId())) {
            throw new Exception("Email address already in use!");
        }

        User user = new User();
        user.setAddress(input.getAddress());
        user.setEmail(input.getEmail());
        user.setName(input.getName());
        user.setPassword(input.getPassword());
        user.setId(input.getUserId());
        repository.save(user);

        return new OutputValues(user);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String name;
        String email;
        String address;
        String password;
        Long userId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        User user;
    }
}
