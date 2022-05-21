package dataJPA.repositories.interfaces;

import dataJPA.entities.DiscographyData;
import org.springframework.data.repository.CrudRepository;

public interface JpaDiscographyRepository extends CrudRepository<DiscographyData, Long> {
}
