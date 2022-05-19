package dataJPA.repositories.interfaces;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;
import dataJPA.entities.AlbumData;
import dataJPA.entities.DiscographyData;
import dataJPA.entities.SongData;
import dataJPA.entities.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaDiscographyRepository extends CrudRepository<DiscographyData, Long> {




}
