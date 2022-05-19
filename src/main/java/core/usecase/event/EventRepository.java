package core.usecase.event;

import core.domain.Comment;
import core.domain.Event;

import java.util.List;

public interface EventRepository {

    boolean existsById(Long id);
    Event getEventById(Long id);
    Event save(Event event);
    List<Comment> getAllComments(Long id);

}
