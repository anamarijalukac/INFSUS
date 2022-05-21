package dataJPA.repositories.impl;


import core.domain.User;
import core.usecase.user.UserRepository;
import dataJPA.entities.UserData;
import dataJPA.repositories.interfaces.JpaUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository repository;

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
