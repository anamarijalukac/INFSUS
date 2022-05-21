package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class AddDiscographyUseCase extends UseCase<AddDiscographyUseCase.InputValues, AddDiscographyUseCase.OutputValues> {

    private final DiscographyRepository repository;

    public AddDiscographyUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        Discography discography = new Discography();
        discography.setAlbumList(input.getAlbumList());
        discography.setId(input.getDiscographyId());

        repository.save(discography);


        return new AddDiscographyUseCase.OutputValues(discography);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        List<Album> albumList;
        Long discographyId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Discography discography;
    }
}
