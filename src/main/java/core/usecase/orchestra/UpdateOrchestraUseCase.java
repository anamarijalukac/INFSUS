package core.usecase.orchestra;

import core.domain.*;
import core.usecase.UseCase;
import lombok.Value;

import java.util.Date;
import java.util.List;

public class UpdateOrchestraUseCase extends UseCase<UpdateOrchestraUseCase.InputValues, UpdateOrchestraUseCase.OutputValues> {

    private final OrchestraRepository repository;


    public UpdateOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Orchestra orchestra = repository.getById(input.getOrchestraId());
        if (input.getName() != null)
            orchestra.setName(input.getName());

        if (input.getFounded_date() != null)
            orchestra.setFounded_date(input.getFounded_date());

        if (input.getMembers() != null)
            orchestra.setMembers(input.getMembers());

        if (input.getLeader() != null)
            orchestra.setLeader(input.getLeader());

        if (input.getWeb_page() != null)
            orchestra.setWeb_page(input.getWeb_page());

        if (input.getDiscography() != null)
            orchestra.setDiscography(input.getDiscography());

        if (input.getEvents() != null)
            orchestra.setEvents(input.getEvents());

        if (input.getRegistrations() != null)
            orchestra.setRegistrations(input.getRegistrations());

        repository.save(orchestra);

        return new UpdateOrchestraUseCase.OutputValues(orchestra);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        String name;
        Date founded_date;
        List<User> members;
        User leader;
        String web_page;
        Discography discography;
        List<Event> events;
        List<Registration> registrations;
        Long orchestraId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Orchestra orchestra;
    }
}
