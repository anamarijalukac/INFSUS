package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.usecase.UseCase;

import java.util.List;

public class AddDiscographyUseCase extends UseCase<AddDiscographyUseCase.InputValues, AddDiscographyUseCase.OutputValues> {


    private final DiscographyRepository repository;

    public AddDiscographyUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        Discography discography = new Discography(

                input.getDiscographyId(), input.getAlbumList()
        );

        repository.save(discography);


        return new AddDiscographyUseCase.OutputValues(discography);

    }

    public static class InputValues implements UseCase.InputValues {
        private final List<Album> albumList;
        private final Long discographyId;

        public InputValues(List<Album> albumList, Long discographyId) {
            this.albumList = albumList;
            this.discographyId = discographyId;
        }

        public List<Album> getAlbumList() {
            return albumList;
        }

        public Long getDiscographyId() {
            return discographyId;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Discography discography;

        public OutputValues(Discography discography) {
            this.discography = discography;
        }
    }
}
