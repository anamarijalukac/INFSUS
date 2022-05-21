package core.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Orchestra {

    private Long id;
    private String name;
    private Date founded_date;
    private String web_page;

    private List<User> members = new ArrayList<>();
    private Discography discography;
    private List<Event> events = new ArrayList<>();
    private List<Registration> registrations = new ArrayList<>();
    private User leader;

    public void addMember(User member) {
        this.members.add(member);
    }

    public void addEvent(Event e) {
        this.events.add(e);
    }

    public void addRegistration(Registration r) {
        this.registrations.add(r);
    }

}
