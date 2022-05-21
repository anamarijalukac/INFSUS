package core.usecase.discography;

import core.domain.Album;

public interface AlbumRepository {

    Album getAlbumById(Long albumId);
}
