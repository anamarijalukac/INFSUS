package presenter.rest.api.entities;

import lombok.Value;

@Value
public class UserRequest {
    Long id;
    String name;
    String email;
}
