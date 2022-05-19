package presenter.config;


import core.usecase.discography.*;
import core.usecase.event.*;
import core.usecase.orchestra.CreateOrchestraUseCase;
import core.usecase.orchestra.GetOrchestraUseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.orchestra.UpdateOrchestraUseCase;
import core.usecase.registration.AcceptRegistrationUseCase;
import core.usecase.registration.CreateRegistrationUseCase;
import core.usecase.registration.GetRegistrationUseCase;
import core.usecase.registration.RegistrationRepository;
import core.usecase.user.CreateUserUseCase;
import core.usecase.user.GetUserUseCase;
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
    public GetUserUseCase getUserUseCase(UserRepository repository) {
        return new GetUserUseCase(repository);
    }


    @Bean
    public AcceptRegistrationUseCase acceptRegistrationUseCase(RegistrationRepository registrationRepo, UserRepository userRepo, OrchestraRepository orchestraRepo) {
        return new AcceptRegistrationUseCase(registrationRepo, userRepo, orchestraRepo);
    }

    @Bean
    public CreateRegistrationUseCase createRegistrationUseCase(RegistrationRepository registrationRepo, UserRepository userRepo, OrchestraRepository orchestraRepo) {
        return new CreateRegistrationUseCase(registrationRepo, userRepo,orchestraRepo);
    }

    @Bean
    public GetRegistrationUseCase getRegistrationUseCase(RegistrationRepository registrationRepo) {
        return new GetRegistrationUseCase(registrationRepo);
    }

    @Bean
    public CreateOrchestraUseCase createOrchestraUseCase(OrchestraRepository orchestraRepository) {
        return new CreateOrchestraUseCase(orchestraRepository);
    }

    @Bean
    public GetOrchestraUseCase getOrchestraUseCase(OrchestraRepository orchestraRepository) {
        return new GetOrchestraUseCase(orchestraRepository);
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
    public GetCommentsUseCase getCommentsUseCase(EventRepository eventRepo) {
        return new GetCommentsUseCase(eventRepo);
    }

    @Bean
    public GetEventUseCase getEventUseCase(EventRepository eventRepo) {
        return new GetEventUseCase(eventRepo);
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

    @Bean
    public GetAlbumByIdUseCase getAlbumByIdUseCase(DiscographyRepository repository) {
        return new GetAlbumByIdUseCase(repository);
    }

    @Bean
    public GetDiscographyByIdUseCase getDiscographyByIdUseCase(DiscographyRepository repository) {
        return new GetDiscographyByIdUseCase(repository);
    }



}
