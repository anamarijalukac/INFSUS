package core.domain;

public class Leader extends User{
    public Leader(String name, String address, String email, String password) {
        super(name, address, email, password);
        this.setStatus("LEADER");
    }
}
