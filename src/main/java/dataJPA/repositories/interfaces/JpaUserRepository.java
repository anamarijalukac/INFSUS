package dataJPA.repositories.interfaces;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import dataJPA.entities.OrchestraData;
import dataJPA.entities.RegistrationData;
import dataJPA.entities.UserData;
import org.springframework.data.repository.CrudRepository;



public interface JpaUserRepository extends CrudRepository<UserData, Long> {

    boolean existsByEmail(String email);

    UserData findByEmail(String email);




}
