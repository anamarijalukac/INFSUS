package core.usecase.user;

import core.domain.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    List<User> findByOrchestraId(Long orchestraId);

    boolean existsById(Long id);

    User findById(Long id);

    User save(User user);
}