package presenter.rest.api.orchestra;

import core.usecase.orchestra.UpdateOrchestraUseCase;
import presenter.rest.api.entities.OrchestraRequest;
import presenter.rest.api.entities.UserRequest;

import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

public final class UpdateOrchestraInputMapper {

    public static UpdateOrchestraUseCase.InputValues map(OrchestraRequest orchestraRequest, Long id) {
        return new UpdateOrchestraUseCase.InputValues(
                orchestraRequest.getName(),
                orchestraRequest.getFounded_date(),
                orchestraRequest.getWeb_page(),
                emptyIfNull(orchestraRequest.getMembers()).stream().map(UpdateOrchestraInputMapper::mapUserRequest).collect(Collectors.toList()),
                orchestraRequest.getLeader() != null ? mapUserRequest(orchestraRequest.getLeader()) : null,
                id);
    }

    private static UpdateOrchestraUseCase.UserInput mapUserRequest(UserRequest userRequest) {
        return new UpdateOrchestraUseCase.UserInput(
                userRequest.getId(),
                userRequest.getName(),
                userRequest.getEmail()
        );
    }
}
