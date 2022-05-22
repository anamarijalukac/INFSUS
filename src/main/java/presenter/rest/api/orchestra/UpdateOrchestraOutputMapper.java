package presenter.rest.api.orchestra;

import core.domain.Orchestra;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import presenter.rest.api.entities.ApiResponse;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

public final class UpdateOrchestraOutputMapper {

    public static ResponseEntity<ApiResponse> map(Orchestra orchestra, HttpServletRequest httpServletRequest) {
        URI location = ServletUriComponentsBuilder
                .fromContextPath(httpServletRequest)
                .path("/orchestra/{id}")
                .buildAndExpand(orchestra.getId())
                .toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "orchestra updated successfully"));
    }
}
