package presenter.rest.api.entities;

import core.domain.Orchestra;
import lombok.Value;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class OrchestraResponse {
    Long id;
    String name;
    Date founded_date;
    String web_page;

    List<UserResponse> members;
    DiscographyResponse discography;
    List<EventResponse> events;
    List<RegistrationResponse> registrations;
    UserResponse leader;

    public static OrchestraResponse from(Orchestra orchestra) {
        return new OrchestraResponse(
                orchestra.getId(),
                orchestra.getName(),
                orchestra.getFounded_date(),
                orchestra.getWeb_page(),
                orchestra.getMembers().stream().map(UserResponse::from).collect(Collectors.toList()),
                DiscographyResponse.from(orchestra.getDiscography()),
                orchestra.getEvents().stream().map(EventResponse::from).collect(Collectors.toList()),
                orchestra.getRegistrations().stream().map(RegistrationResponse::from).collect(Collectors.toList()),
                UserResponse.from(orchestra.getLeader())
        );
    }
}
