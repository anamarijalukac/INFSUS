package dataJPA.entities;

import core.domain.Registration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "registration")
@Table(name = "registration")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RegistrationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean acceptedStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "orchestra_id")
    private OrchestraData orchestra;

    public static RegistrationData from(Registration registration) {
        RegistrationData registrationData = new RegistrationData();
        registrationData.setDate(registration.getDate());
        registrationData.setAcceptedStatus(registration.isAcceptedStatus());
        registrationData.setId(registration.getId());
        registrationData.setDate(registration.getDate());
        registrationData.setOrchestra(OrchestraData.from(registration.getOrchestra()));
        registrationData.setUser(UserData.from(registration.getUser()));
        return registrationData;
    }

    public Registration fromThis() {
        Registration registration = new Registration();
        registration.setUser(this.getUser().fromThis());
        registration.setOrchestra(this.getOrchestra().fromThis());
        registration.setDate(this.getDate());
        registration.setAcceptedStatus(this.isAcceptedStatus());
        registration.setId(this.getId());
        return registration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RegistrationData that = (RegistrationData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
