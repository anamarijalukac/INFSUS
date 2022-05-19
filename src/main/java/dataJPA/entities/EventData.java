package dataJPA.entities;

import core.domain.Comment;
import core.domain.Event;
import core.domain.Orchestra;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "event")
@Table(name = "event")
public class EventData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Date date;


    @ManyToOne
    @JoinColumn(name="orchestra_id")
    private OrchestraData orchestra;

    @OneToMany(mappedBy="event")
    private List<CommentData> comments;

    public EventData(String name, String description, String type, Date date) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public static EventData from(Event c) {
        return new EventData(
               c.getName(),c.getDescription(),c.getType(),c.getDate()
        );
    }

    public Event fromThis() {
        return new Event(
                this.name,this.description,this.type,this.date
        );
    }

    private EventData(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrchestraData getOrchestra() {
        return orchestra;
    }

    public void setOrchestra(OrchestraData orchestra) {
        this.orchestra = orchestra;
    }

    public List<CommentData> getComments() {
        return comments;
    }

    public void setComments(List<CommentData> comments) {
        this.comments = comments;
    }
}
