package dataJPA.repositories.impl;

import core.domain.Comment;
import core.domain.Event;
import core.usecase.event.EventRepository;
import dataJPA.entities.EventData;
import dataJPA.entities.UserData;
import dataJPA.repositories.interfaces.JpaEventRepository;
import dataJPA.repositories.interfaces.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class EventRepositoryImpl implements EventRepository {

    private final JpaEventRepository repository;

    public EventRepositoryImpl(JpaEventRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);

    }

    @Override
    public Event getEventById(Long id) {
        return repository.findById(id).get().fromThis();
    }

    @Override
    public Event save(Event event) {
        final EventData eventData = EventData.from(event);
        return repository.save(eventData).fromThis();
    }

    @Override
    public List<Comment> getAllComments(Long id) {
        Event event=repository.findById(id).get().fromThis();
        return event.getComments();
    }


}
