package core.usecase.user;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;

import java.util.Optional;

public interface UserRepository {


    boolean existsById(Long id);

    User findById(Long id);


    User save(User user);
}