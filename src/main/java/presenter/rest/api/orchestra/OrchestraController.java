package presenter.rest.api.orchestra;

import core.usecase.UseCaseExecutor;
import core.usecase.orchestra.*;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import presenter.rest.api.entities.ApiResponse;
import presenter.rest.api.entities.OrchestraRequest;
import presenter.rest.api.entities.OrchestraResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Component
public class OrchestraController implements OrchestraResource {
    private UseCaseExecutor useCaseExecutor;
    private CreateOrchestraUseCase createOrchestraUseCase;
    private GetOrchestraUseCase getOrchestraUseCase;
    private UpdateOrchestraUseCase updateOrchestraUseCase;
    private GetOrchestrasUseCase getOrchestrasUseCase;
    private DeleteOrchestraUseCase deleteOrchestraUseCase;
    @Autowired
    private RuntimeService runtimeService;

    public OrchestraController(UseCaseExecutor useCaseExecutor,
                               CreateOrchestraUseCase createOrchestraUseCase,
                               GetOrchestraUseCase getOrchestraUseCase,
                               UpdateOrchestraUseCase updateOrchestraUseCase,
                               GetOrchestrasUseCase getOrchestrasUseCase,
                               DeleteOrchestraUseCase deleteOrchestraUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.createOrchestraUseCase = createOrchestraUseCase;
        this.getOrchestraUseCase = getOrchestraUseCase;
        this.updateOrchestraUseCase = updateOrchestraUseCase;
        this.getOrchestrasUseCase = getOrchestrasUseCase;
        this.deleteOrchestraUseCase = deleteOrchestraUseCase;
    }

    @Override
    public CompletableFuture<List<OrchestraResponse>> getAllOrchestras() {
        return useCaseExecutor.execute(
                getOrchestrasUseCase,
                new GetOrchestrasUseCase.InputValues(),
                (outputValues) -> emptyIfNull(outputValues.getOrchestras()).stream().map(OrchestraResponse::from).collect(Collectors.toList())
        );
    }

    @Override
    public CompletableFuture<OrchestraResponse> getByIdentity(Long id) {
        return useCaseExecutor.execute(
                getOrchestraUseCase,
                new GetOrchestraUseCase.InputValues(id),
                (outputValues) -> OrchestraResponse.from(outputValues.getOrchestra())
        );
    }

    @Override
    public CompletableFuture<ApiResponse> signUpUserForOrchestra(Long orchestraId, Long userId) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("orchestraId", orchestraId);
        variables.put("userId", userId);
        runtimeService.startProcessInstanceByKey("usertoorchestrasignup", null, variables);
        ApiResponse apiResponse = new ApiResponse(true, "Sign up request succeded!");
        return CompletableFuture.completedFuture(apiResponse);
    }

    @Override
    public CompletableFuture<ApiResponse> delete(Long id) {
        return useCaseExecutor.execute(
                deleteOrchestraUseCase,
                new DeleteOrchestraUseCase.InputValues(id),
                (outputValues) -> new ApiResponse(true, "Orchestra successfully deleted")
        );    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> create(HttpServletRequest httpServletRequest, OrchestraRequest orchestraRequest) {
        return useCaseExecutor.execute(
                createOrchestraUseCase,
                CreateOrchestraInputMapper.map(orchestraRequest),
                (outputValues) -> CreateOrchestraOutputMapper.map(outputValues.getOrchestra(), httpServletRequest));
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> update(HttpServletRequest httpServletRequest, OrchestraRequest orchestraRequest, Long id) {
        return useCaseExecutor.execute(
                updateOrchestraUseCase,
                UpdateOrchestraInputMapper.map(orchestraRequest, id),
                (outputValues) -> UpdateOrchestraOutputMapper.map(outputValues.getOrchestra(), httpServletRequest));
    }
}
