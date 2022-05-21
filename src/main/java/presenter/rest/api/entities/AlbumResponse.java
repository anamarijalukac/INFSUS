package presenter.rest.api.entities;

import core.domain.Album;
import lombok.Value;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class AlbumResponse {
    Long id;
    List<SongResponse> songs;
    String genre;
    Year year;
    String name;

    public static AlbumResponse from(Album album) {
        return new AlbumResponse(
                album.getId(),
                album.getSongs().stream().map(SongResponse::from).collect(Collectors.toList()),
                album.getGenre(),
                album.getYear(),
                album.getName());
    }
}
