package core.usecase.event;

import core.domain.Comment;
import core.domain.Event;

public interface EventRepository {

    boolean existsByName(String name);

    Event findByName(String name);
    Event save(Event event);

}
