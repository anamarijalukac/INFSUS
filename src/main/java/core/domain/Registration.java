package core.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Registration {

    private Long id;
    private boolean acceptedStatus;
    private User user;
    private Orchestra orchestra;
    private Date date;
}
