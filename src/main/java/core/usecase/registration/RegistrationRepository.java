package core.usecase.registration;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;

import java.util.List;
import java.util.Optional;


public interface RegistrationRepository {


    boolean existsByUserAndOrchestra(User user, Orchestra orchestra);

    Registration findByUserAndOrchestra(User user, Orchestra orchestra);

    boolean ifUserIsMember(User user, Orchestra orchestra);


}