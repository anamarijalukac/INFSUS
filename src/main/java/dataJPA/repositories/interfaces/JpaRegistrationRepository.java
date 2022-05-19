package dataJPA.repositories.interfaces;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;
import dataJPA.entities.OrchestraData;
import dataJPA.entities.RegistrationData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaRegistrationRepository extends CrudRepository<RegistrationData, Long> {


}
