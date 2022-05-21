package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.usecase.UseCase;
import lombok.Value;

import java.time.Year;

public class AddAlbumUseCase extends UseCase<AddAlbumUseCase.InputValues, AddAlbumUseCase.OutputValues> {

    private final DiscographyRepository repository;

    public AddAlbumUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {


        Album album = new Album();

        album.setId(input.getAlbumId());
        album.setName(input.getName());
        album.setGenre(input.getGenre());
        album.setYear(input.getYear());

        Discography discography = repository.getDiscographyById(input.getDiscographyId());

        discography.getAlbumList().add(album);

        repository.save(discography);

        return new AddAlbumUseCase.OutputValues(album);
    }

    public static class InputValues implements UseCase.InputValues {
        private final String genre;
        private final Year year;
        private final String name;
        private final Long albumId;

        private final Long discographyId;


        public InputValues(String genre, Year year, String name, Long albumId, Long discographyId) {
            this.genre = genre;
            this.year = year;
            this.name = name;
            this.albumId = albumId;
            this.discographyId = discographyId;
        }


        public Long getAlbumId() {
            return albumId;
        }

        public Long getDiscographyId() {
            return discographyId;
        }

        public String getGenre() {
            return genre;
        }

        public Year getYear() {
            return year;
        }

        public String getName() {
            return name;
        }
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Album album;
    }
}
