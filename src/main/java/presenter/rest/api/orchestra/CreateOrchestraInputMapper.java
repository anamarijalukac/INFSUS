package presenter.rest.api.orchestra;

import core.usecase.orchestra.CreateOrchestraUseCase;
import presenter.rest.api.entities.OrchestraRequest;
import presenter.rest.api.entities.UserRequest;

import java.util.stream.Collectors;

public final class CreateOrchestraInputMapper {

    public static CreateOrchestraUseCase.InputValues map(OrchestraRequest orchestraRequest) {
        return new CreateOrchestraUseCase.InputValues(
                orchestraRequest.getName(),
                orchestraRequest.getFounded_date(),
                orchestraRequest.getMembers().stream().map(CreateOrchestraInputMapper::mapUserRequest).collect(Collectors.toList()),
                mapUserRequest(orchestraRequest.getLeader()),
                orchestraRequest.getId());
    }

    private static CreateOrchestraUseCase.UserInput mapUserRequest(UserRequest userRequest) {
        return new CreateOrchestraUseCase.UserInput(
                userRequest.getId(),
                userRequest.getName(),
                userRequest.getEmail()
        );
    }
}
