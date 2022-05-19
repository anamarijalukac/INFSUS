package presenter.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"dataJPA.entities"})
@EnableJpaRepositories(basePackages = {"dataJPA.repositories.interfaces"})
public class DBConfig {
}