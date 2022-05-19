package core.domain;

import java.util.Date;

public class Song {

    private String name;
    private Date date;
    private String artist;
    private Long id;

    public Song(String name, Date date, String artist, Long id) {
        this.name = name;
        this.date = date;
        this.artist = artist;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
