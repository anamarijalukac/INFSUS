package core.usecase.user;

import core.domain.User;
import core.usecase.UseCase;

public class CreateUserUseCase extends UseCase<CreateUserUseCase.InputValues, CreateUserUseCase.OutputValues> {

    private final UserRepository repository;

    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (repository.existsByEmail(input.getEmail())) {
            throw new Exception("Email address already in use!");
        }

        User user = new User(
                input.getName(),
                input.getEmail(),
                input.getAddress(),
                input.getPassword()
        );

        repository.save(user);

        return new OutputValues(user);
    }


    public static class InputValues implements UseCase.InputValues{
        private final String name;
        private final String email;
        private final String address;
        private final String password;

        public InputValues(String name, String email, String address, String password) {
            this.name = name;
            this.email = email;
            this.address = address;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getAddress() {
            return address;
        }

        public String getPassword() {
            return password;
        }
    }


    public static class OutputValues implements UseCase.OutputValues {
        private final User user;

        public OutputValues(User user) {
            this.user = user;
        }
    }
}
