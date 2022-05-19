package dataJPA.repositories.interfaces;

import core.domain.Event;
import dataJPA.entities.EventData;
import dataJPA.entities.UserData;
import org.springframework.data.repository.CrudRepository;

public interface JpaEventRepository extends CrudRepository<EventData, Long> {


}
