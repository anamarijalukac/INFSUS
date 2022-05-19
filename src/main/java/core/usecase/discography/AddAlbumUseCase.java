package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.usecase.UseCase;

import java.time.Year;

public class AddAlbumUseCase extends UseCase<AddAlbumUseCase.InputValues, AddAlbumUseCase.OutputValues> {

    private final DiscographyRepository repository;

    public AddAlbumUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {


        Album album=new Album(input.getGenre(),input.getYear(),input.getName(), input.getAlbumId());

        Discography discography= repository.getDiscographyById(input.getDiscographyId());

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

    public static class OutputValues implements UseCase.OutputValues {
        private final Album album;

        public OutputValues(Album album) {
            this.album = album;
        }
    }
}
