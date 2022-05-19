package core.domain;

import java.time.Year;
import java.util.List;

public class Album {

    private List<Song> songs;
    private String genre;
    private Year year;
    private String name;


    public Album(String genre, Year year, String name) {
        this.genre = genre;
        this.year = year;
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSongs(Song song) {
        this.songs.add(song);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}