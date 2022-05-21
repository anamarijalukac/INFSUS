package core.usecase.discography;

import core.domain.Discography;

public interface DiscographyRepository {

    Discography getDiscographyById(Long discographyId);

    Discography save(Discography discography);



}
