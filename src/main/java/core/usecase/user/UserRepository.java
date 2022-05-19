package core.usecase.user;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;

import java.util.Optional;

public interface UserRepository {


    boolean existsByEmail(String email);

    User findByEmail(String email);


    User save(User user);
}