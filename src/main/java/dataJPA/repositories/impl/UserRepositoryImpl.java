package dataJPA.repositories.impl;


import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import core.usecase.user.UserRepository;
import dataJPA.entities.OrchestraData;
import dataJPA.entities.RegistrationData;
import dataJPA.entities.UserData;
import dataJPA.repositories.interfaces.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JpaUserRepository repository;

    public UserRepositoryImpl(JpaUserRepository repository) {
        this.repository = repository;
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
