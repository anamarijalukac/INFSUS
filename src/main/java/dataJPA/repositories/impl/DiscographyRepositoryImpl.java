package dataJPA.repositories.impl;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;
import core.usecase.discography.DiscographyRepository;
import dataJPA.entities.AlbumData;
import dataJPA.entities.DiscographyData;
import dataJPA.entities.SongData;
import dataJPA.entities.UserData;
import dataJPA.repositories.interfaces.JpaDiscographyRepository;
import dataJPA.repositories.interfaces.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
@Repository
public class DiscographyRepositoryImpl implements DiscographyRepository {

    private JpaDiscographyRepository repository;

    public DiscographyRepositoryImpl(JpaDiscographyRepository repository) {
        this.repository = repository;
    }




    @Override
    public Discography getDiscographyById(Long discographyId) {
        return repository.findById(discographyId).get().fromThis();
    }

    @Override
    public Discography save(Discography discography) {
        final DiscographyData discographyData = DiscographyData.from(discography);
        return repository.save(discographyData).fromThis();
    }
}
