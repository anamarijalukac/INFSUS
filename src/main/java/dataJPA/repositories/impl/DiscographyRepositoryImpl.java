package dataJPA.repositories.impl;

import core.domain.Discography;
import core.usecase.discography.DiscographyRepository;
import dataJPA.entities.DiscographyData;
import dataJPA.repositories.interfaces.JpaDiscographyRepository;
import org.springframework.stereotype.Repository;
@Repository
public class DiscographyRepositoryImpl implements DiscographyRepository {

    private final JpaDiscographyRepository repository;

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
