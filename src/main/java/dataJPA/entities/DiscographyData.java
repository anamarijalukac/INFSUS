package dataJPA.entities;


import core.domain.Discography;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity(name = "discography")
@Table(name = "discography")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DiscographyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "discography")
    @ToString.Exclude
    private List<AlbumData> albumList;

    public static DiscographyData from(Discography d) {
        DiscographyData discographyData = new DiscographyData();
        discographyData.setId(d.getId());
        discographyData.setAlbumList(d.getAlbumList().stream().map(AlbumData::from).collect(Collectors.toList()));
        return discographyData;
    }

    public Discography fromThis() {
        Discography discography = new Discography();
        discography.setId(this.getId());
        discography.setAlbumList(this.getAlbumList().stream().map(AlbumData::fromThis).collect(Collectors.toList()));
        return discography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DiscographyData that = (DiscographyData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
