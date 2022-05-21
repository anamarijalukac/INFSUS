package core.usecase.event;

import core.domain.AlreadyExistsException;
import core.domain.Event;
import core.domain.Orchestra;
import core.usecase.UseCase;
import core.usecase.orchestra.OrchestraRepository;
import lombok.Value;

import java.util.Date;

public class AddEventUseCase extends UseCase<AddEventUseCase.InputValues, AddEventUseCase.OutputValues> {


    private final OrchestraRepository orchestraRepo;
    private final EventRepository eventRepo;

    public AddEventUseCase(OrchestraRepository orchestraRepo, EventRepository eventRepo) {
        this.orchestraRepo = orchestraRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public OutputValues execute(InputValues input) {
        if (!eventRepo.existsById(input.getEventId())) {
            throw new AlreadyExistsException("This event already exists!");
        }

        Event event = new Event();
        event.setDate(input.getDate());
        event.setDescription(input.getDescription());
        event.setId(input.getEventId());
        event.setName(input.getName());
        event.setType(input.getType());

        Orchestra orchestra = orchestraRepo.getById(input.getOrchestraId());
        orchestra.getEvents().add(event);
        orchestraRepo.save(orchestra);
        eventRepo.save(event);
        return new AddEventUseCase.OutputValues(event);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String name;
        String description;
        String type;
        Date date;
        Long eventId;
        Long orchestraId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Event event;
    }

}
