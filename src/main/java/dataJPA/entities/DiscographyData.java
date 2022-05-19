package dataJPA.entities;


import core.domain.Album;
import core.domain.Discography;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "discography")
@Table(name = "discography")
public class DiscographyData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "discography")
    private List<AlbumData> albumList;

    public DiscographyData(Long id, List<AlbumData> albumList) {
        this.id = id;
        this.albumList = albumList;
    }

    protected DiscographyData() {

    }

    public static DiscographyData from(Discography d) {
        List<Album> list = d.getAlbumList();
        List<AlbumData> l = new ArrayList<>();
        for (Album a : list) {
            l.add(AlbumData.from(a));
        }
        return new DiscographyData(d.getId(),l);
    }

    public Discography fromThis() {
        List<AlbumData> list = this.getAlbumList();
        List<Album> l = new ArrayList<>();
        for (AlbumData a : list) {
            l.add(a.fromThis());
        }

        return new Discography(this.id,l
        );
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AlbumData> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<AlbumData> albumList) {
        this.albumList = albumList;
    }
}
