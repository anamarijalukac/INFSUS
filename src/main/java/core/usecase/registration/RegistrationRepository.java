package core.usecase.registration;

import core.domain.Registration;

public interface RegistrationRepository {

    boolean existsById(Long id);

    Registration findById(Long id);

    Registration save(Registration registration);


}