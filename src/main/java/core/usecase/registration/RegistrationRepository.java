package core.usecase.registration;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;

import java.util.List;
import java.util.Optional;


public interface RegistrationRepository {


    boolean existsById(Long id);

    Registration findById(Long id);



    Registration save(Registration registration);


}