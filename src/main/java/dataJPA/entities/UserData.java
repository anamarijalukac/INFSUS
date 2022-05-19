package dataJPA.entities;

import core.domain.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Table(name = "user")
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
    private List<RegistrationData> registrationList;

    @ManyToOne
    @JoinColumn(name = "orchestra_id")
    private OrchestraData orchestra;

    public UserData(String name, String email, String address, String password) {

        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    protected UserData() {
    }

    public static UserData from(User c) {
        return new UserData(
                c.getName(),c.getEmail(),c.getAddress(),c.getPassword()
        );
    }

    public User fromThis() {
        return new User(
               this.name,this.email,this.address,this.password
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InstrumentData getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentData instrument) {
        this.instrument = instrument;
    }

    public EducationData getEducation() {
        return education;
    }

    public void setEducation(EducationData education) {
        this.education = education;
    }

    public List<RegistrationData> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<RegistrationData> registrationList) {
        this.registrationList = registrationList;
    }

    public OrchestraData getOrchestra() {
        return orchestra;
    }

    public void setOrchestra(OrchestraData orchestra) {
        this.orchestra = orchestra;
    }
}
