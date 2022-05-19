package dataJPA.entities;


import core.domain.Comment;
import core.domain.Instrument;
import core.domain.User;

import javax.persistence.*;

@Entity(name = "instrument")
@Table(name = "instrument")
public class InstrumentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "instrument")
    private UserData user;


    @Column(unique = true, nullable = false)
    private String name;

    public InstrumentData(String name) {
        this.name = name;
    }

    public static InstrumentData from(Instrument c) {
        return new InstrumentData(
                c.getName()
        );
    }

    public Instrument fromThis() {
        return new Instrument(
                this.name
        );
    }




    protected InstrumentData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
