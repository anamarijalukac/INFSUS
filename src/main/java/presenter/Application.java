package presenter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
        (
                scanBasePackages = {"presenter", "dataJPA"},
                exclude =
                        {
                                org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                                org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
                        }
        )
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}