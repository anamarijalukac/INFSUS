package presenter.rest.api.orchestra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import presenter.rest.api.entities.ApiResponse;
import presenter.rest.api.entities.OrchestraRequest;
import presenter.rest.api.entities.OrchestraResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orchestra")
public interface OrchestraResource {
    @GetMapping
    CompletableFuture<List<OrchestraResponse>> getAllOrchestras();

    @GetMapping("/{id}")
    CompletableFuture<OrchestraResponse> getByIdentity(@PathVariable Long id);

    @DeleteMapping("/{id}")
    CompletableFuture<ApiResponse> delete(@PathVariable Long id);

    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> create(HttpServletRequest httpServletRequest,
                                                          @Valid @RequestBody OrchestraRequest orchestraRequest);

    @PostMapping("/{id}")
    CompletableFuture<ResponseEntity<ApiResponse>> update(HttpServletRequest httpServletRequest,
                                                          @Valid @RequestBody OrchestraRequest orchestraRequest,
                                                          @PathVariable Long id);
}
