package dataJPA.repositories.impl;

import core.domain.Orchestra;
import core.usecase.orchestra.OrchestraRepository;
import dataJPA.entities.EventData;
import dataJPA.entities.OrchestraData;
import dataJPA.repositories.interfaces.JpaEventRepository;
import dataJPA.repositories.interfaces.JpaOrchestraRepository;

public class OrchestraRepositoryImpl implements OrchestraRepository {

    private JpaOrchestraRepository repository;

    public OrchestraRepositoryImpl(JpaOrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);

    }

    @Override
    public Orchestra findByName(String name) {
        return repository.findByName(name).fromThis();
    }

    @Override
    public Orchestra save(Orchestra orchestra) {
        final OrchestraData orchestraData = OrchestraData.from(orchestra);
        return repository.save(orchestraData).fromThis();
    }
}
