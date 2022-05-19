package dataJPA.entities;

import core.domain.Album;
import core.domain.Comment;
import core.domain.Song;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "song")
@Table(name = "song")
public class SongData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String artist;

    @ManyToOne
    @JoinColumn(name="album_id")
    private AlbumData album;

    public SongData(String name, Date date, String artist) {
        this.name = name;
        this.date = date;
        this.artist = artist;
    }

    public static SongData from(Song c) {
        return new SongData(
                c.getName(),c.getDate(),c.getArtist()
        );
    }

    public Song fromThis() {
        return new Song(
                this.name,this.date,this.artist
        );
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

    public AlbumData getAlbum() {
        return album;
    }

    public void setAlbum(AlbumData album) {
        this.album = album;
    }
}
