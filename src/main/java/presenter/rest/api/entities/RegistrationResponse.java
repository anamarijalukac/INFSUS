package presenter.rest.api.entities;

import core.domain.Registration;
import lombok.Value;

import java.util.Date;

@Value
public class RegistrationResponse {
    Long id;
    boolean acceptedStatus;
    UserResponse user;
    OrchestraResponse orchestra;
    Date date;

    public static RegistrationResponse from(Registration registration) {
        return new RegistrationResponse(
                registration.getId(),
                registration.isAcceptedStatus(),
                UserResponse.from(registration.getUser()),
                OrchestraResponse.from(registration.getOrchestra()),
                registration.getDate()
        );
    }
}
