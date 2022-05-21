package dataJPA.entities;

import core.domain.Song;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "song")
@Table(name = "song")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    @JoinColumn(name = "album_id")
    private AlbumData album;

    public static SongData from(Song song) {
        SongData songData = new SongData();
        songData.setDate(song.getDate());
        songData.setArtist(song.getArtist());
        songData.setName(song.getName());
        songData.setId(song.getId());
        return songData;
    }

    public Song fromThis() {
        Song song = new Song();
        song.setName(this.getName());
        song.setDate(this.getDate());
        song.setArtist(this.getArtist());
        song.setId(this.getId());
        return song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SongData songData = (SongData) o;
        return id != null && Objects.equals(id, songData.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
