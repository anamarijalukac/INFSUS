package presenter.rest.api.entities;

import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class OrchestraRequest {
    Long id;
    String name;
    Date founded_date;
    String web_page;
    List<UserRequest> members;
    UserRequest leader;
}
