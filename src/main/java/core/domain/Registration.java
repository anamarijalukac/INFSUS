package core.domain;

import java.util.Date;

public class Registration {

    private boolean acceptedStatus;
    private User user;
    private Orchestra orchestra;
    private Date date;

    private Long id;

    public Registration(User user, Orchestra orchestra, Date date, Long id) {
        this.user = user;
        this.orchestra = orchestra;
        this.date = date;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAcceptedStatus() {
        return acceptedStatus;
    }

    public void setAcceptedStatus(boolean acceptedStatus) {
        this.acceptedStatus = acceptedStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orchestra getOrchestra() {
        return orchestra;
    }

    public void setOrchestra(Orchestra orchestra) {
        this.orchestra = orchestra;
    }
}
