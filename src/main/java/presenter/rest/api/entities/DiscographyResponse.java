package presenter.rest.api.entities;

import core.domain.Discography;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class DiscographyResponse {
    Long id;
    List<AlbumResponse> albumList;

    public static DiscographyResponse from(Discography discography) {
        return new DiscographyResponse(
                discography.getId(),
                discography.getAlbumList().stream().map(AlbumResponse::from).collect(Collectors.toList())
        );
    }
}
