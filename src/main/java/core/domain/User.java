package core.domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String password;
    private Instrument instrument;
    private Education education;
    private List<Registration> registrationList = new ArrayList<>();
    private String status = "USER";
    private Orchestra orchestra;

    public void addRegistration(Registration r) {
        this.registrationList.add(r);
    }
}

