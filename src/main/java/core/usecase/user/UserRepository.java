package core.usecase.user;

import core.domain.User;

public interface UserRepository {


    boolean existsById(Long id);

    User findById(Long id);

    User save(User user);
}