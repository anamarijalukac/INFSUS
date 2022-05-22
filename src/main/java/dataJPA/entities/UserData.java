package dataJPA.entities;

import core.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String password;
    @Column
    private String status;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instrument_id", referencedColumnName = "id")
    private InstrumentData instrument;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    private EducationData education;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<RegistrationData> registrationList;

    @ManyToOne
    @JoinColumn(name = "orchestra_id")
    private OrchestraData orchestra;

    public static UserData from(User user) {
        UserData userData = new UserData();
        userData.setAddress(user.getAddress());
        userData.setEducation(EducationData.from(user.getEducation()));
        userData.setEmail(user.getEmail());
        userData.setId(user.getId());
        userData.setInstrument(InstrumentData.from(user.getInstrument()));
        userData.setName(user.getName());
        userData.setOrchestra(OrchestraData.from(user.getOrchestra()));
        userData.setPassword(user.getPassword());
        userData.setStatus(user.getStatus());
        userData.setRegistrationList(emptyIfNull(user.getRegistrationList()).stream().map(RegistrationData::from).collect(Collectors.toList()));
        return userData;
    }

    public User fromThis() {
        User user = new User();
        user.setId(this.getId());
        user.setName(this.getName());
        user.setPassword(this.getPassword());
        user.setEmail(this.getEmail());
        user.setEducation(this.getEducation().fromThis());
        user.setAddress(this.getAddress());
        user.setInstrument(this.getInstrument().fromThis());
//        user.setOrchestra(this.getOrchestra().fromThis());
        user.setStatus(this.getStatus());
        user.setRegistrationList(emptyIfNull(this.getRegistrationList()).stream().map(RegistrationData::fromThis).collect(Collectors.toList()));
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserData userData = (UserData) o;
        return id != null && Objects.equals(id, userData.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
