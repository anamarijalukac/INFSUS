package dataJPA.entities;

import core.domain.Comment;
import core.domain.Orchestra;
import core.domain.Registration;
import core.domain.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "registration")
@Table(name = "registration")
public class RegistrationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean acceptedStatus;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserData user;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="orchestra_id")
    private OrchestraData orchestra;

    public RegistrationData(UserData user, OrchestraData orchestra, Date date,Long id) {
        this.acceptedStatus = false;
        this.user = user;
        this.orchestra = orchestra;
        this.date = date;
        this.id=id;
    }

    protected RegistrationData(){}

    public static RegistrationData from(Registration c) {


        return new RegistrationData(
                UserData.from(c.getUser()),OrchestraData.from(c.getOrchestra()),c.getDate(),c.getId()

        );
    }

    public Registration fromThis() {
        return new Registration(
                this.user.fromThis(),this.orchestra.fromThis(),this.date,this.id
        );
    }
}
