package dataJPA.entities;

import core.domain.Album;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Entity(name = "album")
@Table(name = "album")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AlbumData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "album")
    @ToString.Exclude
    private List<SongData> songs;

    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private Year year;
    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "discography_id")
    private DiscographyData discography;

    public static AlbumData from(Album a) {
        AlbumData albumData = new AlbumData();
        albumData.setGenre(a.getGenre());
        albumData.setName(a.getName());
        albumData.setId(a.getId());
        albumData.setSongs(a.getSongs().stream().map(SongData::from).collect(Collectors.toList()));
        albumData.setYear(a.getYear());
        albumData.setDiscography(DiscographyData.from(a.getDiscography()));
        return albumData;
    }

    public Album fromThis() {
        Album album = new Album();
        album.setYear(this.getYear());
        album.setName(this.getName());
        album.setSongs(this.getSongs().stream().map(SongData::fromThis).collect(Collectors.toList()));
        album.setGenre(this.getGenre());
        album.setId(this.getId());
        album.setDiscography(this.getDiscography().fromThis());
        return album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AlbumData albumData = (AlbumData) o;
        return id != null && Objects.equals(id, albumData.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
