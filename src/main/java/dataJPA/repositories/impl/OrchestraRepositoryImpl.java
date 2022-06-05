package dataJPA.repositories.impl;

import core.domain.Orchestra;
import core.domain.User;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.user.UserRepository;
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
    private final UserRepository userRepository;

    public OrchestraRepositoryImpl(JpaOrchestraRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public List<Orchestra> getAll() {
        Iterable<OrchestraData> orchestraData = repository.findAll();
        if (orchestraData.spliterator() == null) {
            return Collections.emptyList();
        }
        List<Orchestra> orchestras = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(OrchestraData::fromThis)
                .collect(Collectors.toList());
        for (Orchestra orchestra : orchestras) {
            User leader = orchestra.getLeader();
            if (leader != null) {
                if (leader.getId() != null) {
                    orchestra.setLeader(userRepository.findById(leader.getId()));
                }
            }
        }
        return orchestras;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional
    public Orchestra getById(Long id) {
        Orchestra orchestra = repository.findById(id).get().fromThis();
        User leader = orchestra.getLeader();
        if (leader != null) {
            if (leader.getId() != null) {
                orchestra.setLeader(userRepository.findById(leader.getId()));
            }
        }
        return orchestra;
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
