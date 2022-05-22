package presenter.rest.api.user;

import org.springframework.web.bind.annotation.*;
import presenter.rest.api.entities.UserResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user")
public interface UserResource {
    @GetMapping
    CompletableFuture<List<UserResponse>> getAllUsers();

    @GetMapping("/{id}")
    CompletableFuture<UserResponse> getByIdentity(@PathVariable Long id);
}
