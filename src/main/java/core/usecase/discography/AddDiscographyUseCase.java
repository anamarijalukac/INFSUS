package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Event;
import core.usecase.UseCase;
import core.usecase.event.AddEventUseCase;
import core.usecase.event.EventRepository;

import java.util.List;

public class AddDiscographyUseCase extends UseCase<AddDiscographyUseCase.InputValues, AddDiscographyUseCase.OutputValues> {


    private final DiscographyRepository repository;

    public AddDiscographyUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        Discography discography=new Discography(
                input.getAlbumList()
        );

        return new AddDiscographyUseCase.OutputValues(discography);

    }

    public static class InputValues implements UseCase.InputValues {
        private final  List<Album> albumList;;

        public InputValues(List<Album> albumList) {
            this.albumList = albumList;
        }

        public List<Album> getAlbumList() {
            return albumList;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Discography discography;

        public OutputValues(Discography discography) {
            this.discography = discography;
        }
    }
}
