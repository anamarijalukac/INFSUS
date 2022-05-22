package core.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Album {

    private Long id;
    private List<Song> songs = new ArrayList<>();
    private String genre;
    private String year;
    private String name;
    private Discography discography;

    public void addSong(Song song) {
        this.songs.add(song);
    }
}
