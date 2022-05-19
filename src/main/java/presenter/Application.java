package presenter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = {"presenter", "dataJPA"})
public class Application {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}