package dataJPA.repositories.interfaces;

import dataJPA.entities.AlbumData;
import org.springframework.data.repository.CrudRepository;

public interface JpaAlbumRepository extends CrudRepository<AlbumData, Long> {
}
