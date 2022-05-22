package core.entities;


import com.github.javafaker.Faker;
import core.domain.*;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class TestCoreEntityGenerator {

    private static final Faker faker = new Faker();

    public static Integer randomQuantity() {
        return randomNumberBetweenFiveAndTen();
    }

    public static Long randomId() {
        return faker.number().randomNumber();
    }

    private static int randomNumberBetweenFiveAndTen() {
        return faker.number().numberBetween(5, 10);
    }

    public static <T> List<T> randomItemsOf(Supplier<T> generator) {
        return IntStream.rangeClosed(0, randomNumberBetweenFiveAndTen())
                .mapToObj(number -> (T) generator.get())
                .collect(Collectors.toList());
    }

    public static Orchestra randomOrchestra() {
        Orchestra orchestra = new Orchestra();
        orchestra.setId(randomId());
        orchestra.setWeb_page(faker.internet().url());
        orchestra.setLeader(randomUser());
        orchestra.setMembers(randomItemsOf(TestCoreEntityGenerator::randomUser));
        orchestra.setName(faker.name().title());
        orchestra.setDiscography(randomDiscography());
        orchestra.setFounded_date(faker.date().birthday());
        List<Registration> registrations = randomItemsOf(TestCoreEntityGenerator::randomRegistration);
        registrations.forEach(registration -> registration.setOrchestra(orchestra));
        orchestra.setRegistrations(registrations);
        orchestra.setEvents(randomItemsOf(TestCoreEntityGenerator::randomEvent));
        return orchestra;
    }

    public static Orchestra randomOrchestra(Long id, User leader, List<User> members, Discography discography, List<Registration> registrations, List<Event> events) {
        Orchestra orchestra = new Orchestra();
        orchestra.setId(id);
        orchestra.setWeb_page(faker.internet().url());
        orchestra.setLeader(leader);
        orchestra.setMembers(members);
        orchestra.setName(faker.name().title());
        orchestra.setDiscography(discography);
        orchestra.setFounded_date(faker.date().birthday());
        registrations.forEach(registration -> registration.setOrchestra(orchestra));
        orchestra.setRegistrations(registrations);
        orchestra.setEvents(events);
        return orchestra;
    }

    public static User randomUser() {
        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setName(faker.name().username());
        user.setId(randomId());
        user.setStatus("USER");
        user.setInstrument(randomInstrument());
        List<Registration> registrations = randomItemsOf(TestCoreEntityGenerator::randomRegistration);
        registrations.forEach(registration -> registration.setUser(user));
        user.setRegistrationList(registrations);
        user.setAddress(faker.address().fullAddress());
        user.setEducation(randomEducation());
        user.setPassword(faker.internet().password());
        return user;
    }

    public static Instrument randomInstrument() {
        Instrument instrument = new Instrument();
        instrument.setName(faker.music().instrument());
        instrument.setId(randomId());
        return instrument;
    }

    public static Education randomEducation() {
        Education education = new Education();
        education.setName(faker.educator().university());
        education.setLevel(faker.educator().course());
        education.setId(randomId());
        return education;
    }

    public static Registration randomRegistration() {
        Registration registration = new Registration();
        registration.setId(randomId());
        registration.setDate(faker.date().birthday());
        registration.setAcceptedStatus(faker.bool().bool());
        return registration;
    }

    public static Event randomEvent() {
        Event event = new Event();
        event.setId(randomId());
        event.setDescription(faker.lorem().sentence());
        event.setComments(randomItemsOf(TestCoreEntityGenerator::randomComment));
        event.setName(faker.name().title());
        event.setType(faker.lorem().word());
        event.setDate(faker.date().birthday());
        return event;
    }

    public static Comment randomComment() {
        Comment comment = new Comment();
        comment.setCommentText(faker.lorem().sentence());
        comment.setCommentatorName(faker.name().fullName());
        comment.setId(randomId());
        return comment;
    }

    public static Discography randomDiscography() {
        Discography discography = new Discography();
        List<Album> albumList = randomItemsOf(TestCoreEntityGenerator::randomAlbum);
        albumList.forEach(album -> album.setDiscography(discography));
        discography.setAlbumList(albumList);
        return discography;
    }

    public static Album randomAlbum() {
        Album album = new Album();
        album.setGenre(faker.lorem().word());
        album.setSongs(randomItemsOf(TestCoreEntityGenerator::randomSong));
        album.setYear(faker.date().birthday().toString());
        album.setName(faker.name().title());
        album.setId(randomId());
        return album;
    }

    public static Song randomSong() {
        Song song = new Song();
        song.setId(randomId());
        song.setArtist(faker.artist().name());
        song.setName(faker.name().title());
        song.setDate(faker.date().birthday());
        return song;
    }
}
