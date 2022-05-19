package core.domain;

import java.util.Date;

public class Song {

    private String name;
    private Date date;
    private String artist;

    public Song(String name, Date date, String artist) {
        this.name = name;
        this.date = date;
        this.artist = artist;
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
