package core.usecase.orchestra;

import core.domain.User;
import core.usecase.UseCase;
import core.usecase.user.UserRepository;
import lombok.Value;

import java.util.List;

public class DeleteOrchestraUseCase extends UseCase<DeleteOrchestraUseCase.InputValues, DeleteOrchestraUseCase.OutputValues> {
    private OrchestraRepository orchestraRepository;
    private UserRepository userRepository;

    public DeleteOrchestraUseCase(OrchestraRepository orchestraRepository, UserRepository userRepository) {
        this.orchestraRepository = orchestraRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        final Long id = input.getId();
        if (orchestraRepository.existsById(id)) {
            List<User> userList = userRepository.findByOrchestraId(id);
            userList.forEach(user -> {
                user.setOrchestra(null);
                userRepository.save(user);
            });
        }
        orchestraRepository.delete(id);

        return new OutputValues(!orchestraRepository.existsById(id));
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        boolean deleted;
    }
}
