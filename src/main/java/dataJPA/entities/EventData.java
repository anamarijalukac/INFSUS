package dataJPA.entities;

import core.domain.Event;
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

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Entity(name = "event")
@Table(name = "event")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orchestra_id")
    private OrchestraData orchestra;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<CommentData> comments;

    public static EventData from(Event event) {
        EventData eventData = new EventData();
        eventData.setDate(event.getDate());
        eventData.setComments(emptyIfNull(event.getComments()).stream().map(CommentData::from).collect(Collectors.toList()));
        eventData.setDescription(event.getDescription());
        eventData.setId(event.getId());
        eventData.setName(event.getName());
        eventData.setType(event.getType());
        return eventData;
    }

    public Event fromThis() {
        Event event = new Event();
        event.setType(this.getType());
        event.setDate(this.getDate());
        event.setName(this.getName());
        event.setDescription(this.getDescription());
        event.setComments(emptyIfNull(this.getComments()).stream().map(CommentData::fromThis).collect(Collectors.toList()));
        event.setId(this.getId());
        return event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventData eventData = (EventData) o;
        return id != null && Objects.equals(id, eventData.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
