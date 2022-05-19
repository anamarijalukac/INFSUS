package core.domain;

import java.util.List;

public class Discography {

    private List<Album> albumList;


    public Discography(List<Album> albumList) {
        this.albumList = albumList;
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
