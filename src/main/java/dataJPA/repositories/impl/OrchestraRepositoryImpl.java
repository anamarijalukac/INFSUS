package dataJPA.repositories.impl;

import core.domain.Orchestra;
import core.usecase.orchestra.OrchestraRepository;
import dataJPA.entities.OrchestraData;
import dataJPA.repositories.interfaces.JpaOrchestraRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class OrchestraRepositoryImpl implements OrchestraRepository {

    private final JpaOrchestraRepository repository;

    public OrchestraRepositoryImpl(JpaOrchestraRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public List<Orchestra> getAll() {
        Iterable<OrchestraData> orchestraData = repository.findAll();
        if (orchestraData.spliterator() == null) {
            return Collections.emptyList();
        }
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(OrchestraData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional
    public Orchestra getById(Long id) {
        return repository.findById(id).get().fromThis();
    }

    @Override
    @Transactional
    public Orchestra save(Orchestra orchestra) {
        final OrchestraData orchestraData = OrchestraData.from(orchestra);
        return repository.save(orchestraData).fromThis();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
