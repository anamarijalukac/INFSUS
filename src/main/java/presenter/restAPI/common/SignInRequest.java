package presenter.restAPI.common;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignInRequest {

    @Email
    @NotBlank
    private final String email;

    @NotBlank
    @Size(min = 6, max = 50)
    private final String password;

    public SignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}