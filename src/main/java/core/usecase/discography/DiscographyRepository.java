package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;
import core.domain.User;
import dataJPA.entities.AlbumData;
import dataJPA.entities.DiscographyData;
import dataJPA.entities.SongData;

import java.util.List;

public interface DiscographyRepository {




    Discography getDiscographyById(Long discographyId);

    Discography save(Discography discography);



}
