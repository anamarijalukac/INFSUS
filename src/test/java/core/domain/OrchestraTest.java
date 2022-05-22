package core.domain;

import core.entities.TestCoreEntityGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static core.entities.TestCoreEntityGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;


public class OrchestraTest {

    @Test
    public void newInstance() {
        Long id = randomId();
        User leader = randomUser();
        List<User> members = randomItemsOf(TestCoreEntityGenerator::randomUser);
        Discography discography = randomDiscography();
        List<Registration> registrations = randomItemsOf(TestCoreEntityGenerator::randomRegistration);
        List<Event> events = randomItemsOf(TestCoreEntityGenerator::randomEvent);
        Orchestra actual = randomOrchestra(
                id,
                leader,
                members,
                discography,
                registrations,
                events
        );
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getLeader()).isEqualTo(leader);
        assertThat(actual.getMembers()).isEqualTo(members);
        assertThat(actual.getDiscography()).isEqualTo(discography);
        assertThat(actual.getRegistrations()).isEqualTo(registrations);
        assertThat(actual.getEvents()).isEqualTo(events);
    }
}
