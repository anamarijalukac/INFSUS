package dataJPA.repositories.impl;

import core.domain.Comment;
import core.domain.Event;
import core.usecase.event.EventRepository;
import dataJPA.entities.EventData;
import dataJPA.entities.UserData;
import dataJPA.repositories.interfaces.JpaEventRepository;
import dataJPA.repositories.interfaces.JpaUserRepository;

public class EventRepositoryImpl implements EventRepository {

    private JpaEventRepository repository;

    public EventRepositoryImpl(JpaEventRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean existsByName(String name) {

        return repository.existsByName(name);
    }

    @Override
    public Event findByName(String name) {
        return repository.findByName(name).fromThis();
    }

    @Override
    public Event save(Event event) {
        final EventData eventData = EventData.from(event);
        return repository.save(eventData).fromThis();
    }


}
