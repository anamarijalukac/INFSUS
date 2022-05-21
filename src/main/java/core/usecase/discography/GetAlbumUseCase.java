package core.usecase.discography;

import core.domain.Album;
import core.domain.NotFoundException;
import core.usecase.UseCase;
import lombok.Value;


public class GetAlbumUseCase extends UseCase<GetAlbumUseCase.InputValues, GetAlbumUseCase.OutputValues> {

    private final AlbumRepository repository;

    public GetAlbumUseCase(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        final Long id = input.getAlbumId();

        Album album = repository.getAlbumById(id);

        if (album == null) {
            throw new NotFoundException("Album " + id + " not found");
        }

        return new OutputValues(album);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long albumId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Album album;
    }
}
