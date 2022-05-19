package core.domain;

import java.util.Date;
import java.util.List;

public class Event {

    private String name;
    private String description;
    private String type;
    private Date date;
    private List<Comment> comments;

    public Event(String name, String description, String type, Date date) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
