package presenter.config;


import core.usecase.discography.AddAlbumUseCase;
import core.usecase.discography.AddDiscographyUseCase;
import core.usecase.discography.AddSongUseCase;
import core.usecase.discography.DiscographyRepository;
import core.usecase.event.AddCommentUseCase;
import core.usecase.event.AddEventUseCase;
import core.usecase.event.EventRepository;
import core.usecase.orchestra.CreateOrchestraUseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.orchestra.UpdateOrchestraUseCase;
import core.usecase.registration.AcceptRegistrationUseCase;
import core.usecase.registration.CreateRegistrationUseCase;
import core.usecase.registration.RegistrationRepository;
import core.usecase.user.CreateUserUseCase;
import core.usecase.user.UpdateUserUseCase;
import core.usecase.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository repository) {
        return new CreateUserUseCase(repository);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository repository) {
        return new UpdateUserUseCase(repository);
    }

    @Bean
    public AcceptRegistrationUseCase acceptRegistrationUseCase(RegistrationRepository registrationRepo, UserRepository userRepo, OrchestraRepository orchestraRepo) {
        return new AcceptRegistrationUseCase(registrationRepo, userRepo, orchestraRepo);
    }

    @Bean
    public CreateRegistrationUseCase createRegistrationUseCase(RegistrationRepository registrationRepo, UserRepository userRepo) {
        return new CreateRegistrationUseCase(registrationRepo, userRepo);
    }

    @Bean
    public CreateOrchestraUseCase createOrchestraUseCase(OrchestraRepository orchestraRepository) {
        return new CreateOrchestraUseCase(orchestraRepository);
    }

    @Bean
    public UpdateOrchestraUseCase updateOrchestraUseCase(OrchestraRepository orchestraRepository) {
        return new UpdateOrchestraUseCase(orchestraRepository);
    }

    @Bean
    public AddEventUseCase addEventUseCase(OrchestraRepository orchestraRepo, EventRepository eventRepo) {
        return new AddEventUseCase(orchestraRepo, eventRepo);
    }

    @Bean
    public AddCommentUseCase addCommentUseCase(EventRepository eventRepo) {
        return new AddCommentUseCase(eventRepo);
    }

    @Bean
    public AddAlbumUseCase addAlbumUseCase(DiscographyRepository repository) {
        return new AddAlbumUseCase(repository);
    }

    @Bean
    public AddDiscographyUseCase addDiscographyUseCase(DiscographyRepository repository) {
        return new AddDiscographyUseCase(repository);
    }

    @Bean
    public AddSongUseCase addSongUseCase(DiscographyRepository repository) {
        return new AddSongUseCase(repository);
    }



}
