package presenter.rest.api.entities;

import core.domain.Event;
import lombok.Value;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class EventResponse {
    Long id;
    String name;
    String description;
    String type;
    Date date;
    List<CommentResponse> comments;

    public static EventResponse from(Event event) {
        return new EventResponse(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getType(),
                event.getDate(),
                event.getComments().stream().map(CommentResponse::from).collect(Collectors.toList())
        );
    }
}
