package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;

public interface DiscographyRepository {

    void addAlbum(Discography discography, Album album);
    void addSong(Album album, Song song);



}
