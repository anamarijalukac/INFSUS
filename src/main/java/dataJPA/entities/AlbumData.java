package dataJPA.entities;

import core.domain.Album;
import core.domain.Song;

import javax.persistence.*;
import java.time.Year;
import java.util.List;


@Entity(name = "album")
@Table(name = "album")
public class AlbumData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="album")
    private List<SongData> songs;

    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private Year year;
    @Column(unique = true,nullable = false)
    private String name;

    public AlbumData(Long id,String genre, Year year, String name) {
        this.id=id;
        this.genre = genre;
        this.year = year;
        this.name = name;
    }

    protected AlbumData() {
    }

    public static AlbumData from(Album a) {
        return new AlbumData(a.getId(),
                a.getGenre(),
                a.getYear(),
                a.getName()
        );
    }

    public Album fromThis() {
        return new Album(
               this.genre,this.year,this.name,this.id
        );
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SongData> getSongs() {
        return songs;
    }

    public void setSongs(List<SongData> songs) {
        this.songs = songs;
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
