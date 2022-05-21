package dataJPA.repositories.impl;

import core.domain.Album;
import core.usecase.discography.AlbumRepository;
import dataJPA.repositories.interfaces.JpaAlbumRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    private final JpaAlbumRepository repository;

    public AlbumRepositoryImpl(JpaAlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public Album getAlbumById(Long albumId) {
        return repository.findById(albumId).get().fromThis();
    }
}
