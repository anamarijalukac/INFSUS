package dataJPA.repositories.interfaces;

import core.domain.Orchestra;
import dataJPA.entities.EventData;
import dataJPA.entities.OrchestraData;
import org.springframework.data.repository.CrudRepository;

public interface JpaOrchestraRepository extends CrudRepository<OrchestraData, Long> {


}
