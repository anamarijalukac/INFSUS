package dataJPA.entities;


import core.domain.Instrument;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "instrument")
@Table(name = "instrument")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InstrumentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "instrument")
    private UserData user;


    @Column(unique = true, nullable = false)
    private String name;

    public static InstrumentData from(Instrument instrument) {
        InstrumentData instrumentData = new InstrumentData();
        instrumentData.setId(instrument.getId());
        instrumentData.setName(instrument.getName());

        return instrumentData;
    }

    public Instrument fromThis() {
        Instrument instrument = new Instrument();
        instrument.setId(this.getId());
        instrument.setName(this.getName());
        return instrument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InstrumentData that = (InstrumentData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
