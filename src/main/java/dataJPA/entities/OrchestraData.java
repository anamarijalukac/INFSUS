package dataJPA.entities;

import core.domain.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "orchestra")
@Table(name = "orchestra")
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


    @OneToMany(mappedBy="orchestra")
    private List<UserData> members;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discography_id", referencedColumnName = "id")
    private DiscographyData discography;


    @OneToMany(mappedBy="orchestra")
    private List<EventData> events;


    @OneToMany(mappedBy="orchestra")
    private List<RegistrationData> registrations;




    public OrchestraData(String name, Date founded_date) {
        this.name = name;
        this.founded_date = founded_date;
    }

    protected OrchestraData() {
    }

    public static OrchestraData from(Orchestra c) {
        return new OrchestraData(
               c.getName(),c.getFounded_date()
        );
    }

    public Orchestra fromThis() {
        return new Orchestra(
                this.name,this.founded_date
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

    public Date getFounded_date() {
        return founded_date;
    }

    public void setFounded_date(Date founded_date) {
        this.founded_date = founded_date;
    }

    public String getWeb_page() {
        return web_page;
    }

    public void setWeb_page(String web_page) {
        this.web_page = web_page;
    }

    public List<UserData> getMembers() {
        return members;
    }

    public void setMembers(List<UserData> members) {
        this.members = members;
    }

    public DiscographyData getDiscography() {
        return discography;
    }

    public void setDiscography(DiscographyData discography) {
        this.discography = discography;
    }

    public List<EventData> getEvents() {
        return events;
    }

    public void setEvents(List<EventData> events) {
        this.events = events;
    }

    public List<RegistrationData> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationData> registrations) {
        this.registrations = registrations;
    }
}
