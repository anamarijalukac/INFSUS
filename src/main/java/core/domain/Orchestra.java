package core.domain;

import java.util.Date;
import java.util.List;

public class Orchestra {

    private String name;
    private Date founded_date;
    private String web_page;

    private List<User> members;
    private Discography discography;
    private List<Event> events;
    private List<Registration> registrations;
    private User leader;

    public Orchestra(String name, Date founded_date) {
        this.name = name;
        this.founded_date=founded_date;

    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
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

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void addMember(User member) {
        this.members.add(member);
    }

    public Discography getDiscography() {
        return discography;
    }

    public void setDiscography(Discography discography) {
        this.discography = discography;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event e) {
        this.events.add(e);
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public void addRegistration(Registration r) {
        this.registrations.add(r);
    }




}
