package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;
import core.usecase.UseCase;
import lombok.Value;

import java.util.Date;

public class AddSongUseCase extends UseCase<AddSongUseCase.InputValues, AddSongUseCase.OutputValues> {

    private final DiscographyRepository repository;

    public AddSongUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        Song song = new Song();
        song.setArtist(input.getArtist());
        song.setDate(input.getDate());
        song.setId(input.getSongId());
        song.setName(input.getName());

        Discography discography = repository.getDiscographyById(input.getDiscographyId());
        Album result = null;
        for (Album a : discography.getAlbumList()) {
            if (a.getId().equals(input.getAlbumId())) {
                result = a;
            }
        }

        discography.getAlbumList().remove(result);
        assert result != null;
        result.getSongs().add(song);
        discography.getAlbumList().add(result);

        repository.save(discography);


        return new AddSongUseCase.OutputValues(song);

    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String name;
        Date date;
        String artist;
        Long songId;
        Long discographyId;
        Long albumId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Song song;
    }
}
