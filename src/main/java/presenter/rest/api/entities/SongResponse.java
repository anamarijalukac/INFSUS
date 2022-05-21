package presenter.rest.api.entities;

import core.domain.Song;
import lombok.Value;

import java.util.Date;

@Value
public class SongResponse {
    String name;
    Date date;
    String artist;
    Long id;

    public static SongResponse from(Song song) {
        return new SongResponse(
                song.getName(),
                song.getDate(),
                song.getArtist(),
                song.getId()
        );
    }
}
