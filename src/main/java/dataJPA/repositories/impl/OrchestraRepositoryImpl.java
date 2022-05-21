package dataJPA.repositories.impl;

import core.domain.Orchestra;
import core.usecase.orchestra.OrchestraRepository;
import dataJPA.entities.OrchestraData;
import dataJPA.repositories.interfaces.JpaOrchestraRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrchestraRepositoryImpl implements OrchestraRepository {

    private final JpaOrchestraRepository repository;

    public OrchestraRepositoryImpl(JpaOrchestraRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Orchestra getById(Long id) {
        return repository.findById(id).get().fromThis();
    }

    @Override
    public Orchestra save(Orchestra orchestra) {
        final OrchestraData orchestraData = OrchestraData.from(orchestra);
        return repository.save(orchestraData).fromThis();
    }
}
