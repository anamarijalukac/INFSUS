package presenter.restAPI.user;

import core.domain.User;
import core.usecase.UseCaseExecutor;
import core.usecase.user.CreateUserUseCase;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import presenter.restAPI.common.SignInRequest;
import presenter.restAPI.common.SignUpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.concurrent.CompletableFuture;

@Controller
public class UserController implements UserResource{

    private final UseCaseExecutor useCaseExecutor;
    private final CreateUserUseCase createUserUseCase;

    public UserController(UseCaseExecutor useCaseExecutor, CreateUserUseCase createUserUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public CompletableFuture<ResponseEntity<HttpTrace.Response>> signUp(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest httpServletRequest) {

        return useCaseExecutor.execute(createUserUseCase,
                new CreateUserUseCase.InputValues(
                        signUpRequest.getName(),
                        signUpRequest.getEmail(),
                        signUpRequest.getAddress(),
                        signUpRequest.getPassword()),
                (outputValues) ->  CreateCustomerUseCaseOutputMapper.map(outputValues.getUser(), httpServletRequest));

    }

    @Override
    public CompletableFuture<ResponseEntity<Authentication>> signIn(SignInRequest request) {
        return null;
    }




}


final class CreateCustomerUseCaseOutputMapper {
    public static ResponseEntity<HttpStatus> map(User user, HttpServletRequest httpServletRequest) {
        URI location = ServletUriComponentsBuilder
                .fromContextPath(httpServletRequest)
                .path("/user/{id}")
                .buildAndExpand(user.getName())
                .toUri();

        return ResponseEntity.created(location).body( HttpStatus.OK);
    }
}
