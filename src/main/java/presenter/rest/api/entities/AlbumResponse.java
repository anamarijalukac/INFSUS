package presenter.rest.api.entities;

import core.domain.Album;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Value
public class AlbumResponse {
    Long id;
    List<SongResponse> songs;
    String genre;
    String year;
    String name;

    public static AlbumResponse from(Album album) {
        return new AlbumResponse(
                album.getId(),
                emptyIfNull(album.getSongs()).stream().map(SongResponse::from).collect(Collectors.toList()),
                album.getGenre(),
                album.getYear(),
                album.getName());
    }
}
