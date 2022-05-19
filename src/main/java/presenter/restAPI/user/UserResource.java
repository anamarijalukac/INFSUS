package presenter.restAPI.user;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import presenter.restAPI.common.SignInRequest;
import presenter.restAPI.common.SignUpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user")
public interface UserResource {

    @PostMapping
    CompletableFuture<ResponseEntity<HttpTrace.Response>> signUp(
            @Valid @RequestBody SignUpRequest request, HttpServletRequest httpServletRequest);

    @PostMapping("/auth")
    CompletableFuture<ResponseEntity<Authentication>> signIn(@Valid @RequestBody SignInRequest request);
}