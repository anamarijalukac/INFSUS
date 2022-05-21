package dataJPA.entities;

import core.domain.Orchestra;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity(name = "orchestra")
@Table(name = "orchestra")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrchestraData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private Date founded_date;
    @Column
    private String web_page;


    @OneToMany(mappedBy = "orchestra")
    @ToString.Exclude
    private List<UserData> members;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discography_id", referencedColumnName = "id")
    private DiscographyData discography;


    @OneToMany(mappedBy = "orchestra")
    @ToString.Exclude
    private List<EventData> events;


    @OneToMany(mappedBy = "orchestra")
    @ToString.Exclude
    private List<RegistrationData> registrations;

    public static OrchestraData from(Orchestra orchestra) {
        OrchestraData orchestraData = new OrchestraData();
        orchestraData.setDiscography(DiscographyData.from(orchestra.getDiscography()));
        orchestraData.setId(orchestra.getId());
        orchestraData.setEvents(orchestra.getEvents().stream().map(EventData::from).collect(Collectors.toList()));
        orchestraData.setName(orchestra.getName());
        orchestraData.setFounded_date(orchestra.getFounded_date());
        orchestraData.setMembers(orchestra.getMembers().stream().map(UserData::from).collect(Collectors.toList()));
        orchestraData.setRegistrations(orchestra.getRegistrations().stream().map(RegistrationData::from).collect(Collectors.toList()));
        orchestraData.setWeb_page(orchestra.getWeb_page());
        return orchestraData;
    }

    public Orchestra fromThis() {
        Orchestra orchestra = new Orchestra();
        orchestra.setId(this.getId());
        orchestra.setDiscography(this.getDiscography().fromThis());
        orchestra.setEvents(this.getEvents().stream().map(EventData::fromThis).collect(Collectors.toList()));
        orchestra.setFounded_date(this.getFounded_date());
        orchestra.setMembers(this.getMembers().stream().map(UserData::fromThis).collect(Collectors.toList()));
        orchestra.setRegistrations(this.getRegistrations().stream().map(RegistrationData::fromThis).collect(Collectors.toList()));
        orchestra.setName(this.getName());
        orchestra.setWeb_page(this.getWeb_page());
        return orchestra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrchestraData that = (OrchestraData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
