package core.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Discography {

    private Long id;
    private List<Album> albumList = new ArrayList<>();

    public void addAlbum(Album album) {
        this.albumList.add(album);
    }
}
