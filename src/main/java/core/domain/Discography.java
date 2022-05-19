package core.domain;

import java.util.List;

public class Discography {

    private List<Album> albumList;
    private Long id;


    public Discography(Long id,List<Album> albumList) {
        this.albumList=albumList;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public void addAlbum(Album album) {
        this.albumList.add(album);
    }

}
