package presenter.rest.api.user;

import core.usecase.UseCaseExecutor;
import core.usecase.user.GetUserUseCase;
import core.usecase.user.GetUsersUseCase;
import org.springframework.stereotype.Component;
import presenter.rest.api.entities.UserResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Component
public class UserController implements UserResource {
    private UseCaseExecutor useCaseExecutor;
    private GetUserUseCase getUserUseCase;
    private GetUsersUseCase getUsersUseCase;

    public UserController(UseCaseExecutor useCaseExecutor, GetUserUseCase getUserUseCase, GetUsersUseCase getUsersUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.getUserUseCase = getUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
    }

    @Override
    public CompletableFuture<List<UserResponse>> getAllUsers() {
        return useCaseExecutor.execute(
                getUsersUseCase,
                new GetUsersUseCase.InputValues(),
                (outputValues) -> emptyIfNull(outputValues.getUsers()).stream().map(UserResponse::from).collect(Collectors.toList())
        );
    }

    @Override
    public CompletableFuture<UserResponse> getByIdentity(Long id) {
        return useCaseExecutor.execute(
                getUserUseCase,
                new GetUserUseCase.InputValues(id),
                (outputValues) -> UserResponse.from(outputValues.getUser())
        );
    }
}
