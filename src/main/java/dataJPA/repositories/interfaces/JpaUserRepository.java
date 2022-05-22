package dataJPA.repositories.interfaces;

import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;
import dataJPA.entities.OrchestraData;
import dataJPA.entities.RegistrationData;
import dataJPA.entities.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface JpaUserRepository extends CrudRepository<UserData, Long> {

    boolean existsByEmail(String email);

    UserData findByEmail(String email);

    List<UserData> findByOrchestra_Id(Long id);




}
