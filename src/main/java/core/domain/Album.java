package core.domain;

import lombok.Data;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Data
public class Album {

    private Long id;
    private List<Song> songs = new ArrayList<>();
    private String genre;
    private Year year;
    private String name;
    private Discography discography;

    public void addSong(Song song) {
        this.songs.add(song);
    }
}
