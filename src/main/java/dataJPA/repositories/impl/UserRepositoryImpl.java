package dataJPA.repositories.impl;


import core.domain.User;
import core.usecase.user.UserRepository;
import dataJPA.entities.OrchestraData;
import dataJPA.entities.UserData;
import dataJPA.repositories.interfaces.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository repository;

    public UserRepositoryImpl(JpaUserRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<User> getAll() {
        Iterable<UserData> userData = repository.findAll();
        if (userData.spliterator() == null) {
            return Collections.emptyList();
        }
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(UserData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).get().fromThis();
    }

    @Override
    public User save(User user) {
        final UserData userData = UserData.from(user);
        return repository.save(userData).fromThis();
    }
}
