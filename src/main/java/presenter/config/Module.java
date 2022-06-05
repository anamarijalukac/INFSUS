package presenter.config;


import camunda.SendInformation;
import camunda.SignUpRequest;
import core.service.EmailService;
import core.service.EmailServiceImpl;
import core.usecase.discography.*;
import core.usecase.event.*;
import core.usecase.orchestra.*;
import core.usecase.registration.AcceptRegistrationUseCase;
import core.usecase.registration.CreateRegistrationUseCase;
import core.usecase.registration.GetRegistrationUseCase;
import core.usecase.registration.RegistrationRepository;
import core.usecase.user.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class Module {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository repository) {
        return new CreateUserUseCase(repository);
    }

    @Bean
    public EmailService emailService(JavaMailSender javaMailSender) {
        return new EmailServiceImpl(javaMailSender);
    }

    @Bean
    public SendInformation sendInformation(UserRepository userRepository, OrchestraRepository orchestraRepository, EmailService emailService) {
        return new SendInformation(userRepository, orchestraRepository, emailService);
    }

    @Bean
    public SignUpRequest signUpRequest(OrchestraRepository orchestraRepository) {
        return new SignUpRequest(orchestraRepository);
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
    public GetUsersUseCase getUsersUseCase(UserRepository repository) {
        return new GetUsersUseCase(repository);
    }

    @Bean
    public DeleteOrchestraUseCase deleteOrchestraUseCase(OrchestraRepository orchestraRepository, UserRepository userRepository) {
        return new DeleteOrchestraUseCase(orchestraRepository, userRepository);
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
    public GetAlbumUseCase getAlbumByIdUseCase(AlbumRepository repository) {
        return new GetAlbumUseCase(repository);
    }

    @Bean
    public GetDiscographyUseCase getDiscographyByIdUseCase(DiscographyRepository repository) {
        return new GetDiscographyUseCase(repository);
    }

    @Bean
    public GetOrchestrasUseCase getOrchestrasUseCase(OrchestraRepository orchestraRepository) {
        return new GetOrchestrasUseCase(orchestraRepository);
    }

}
