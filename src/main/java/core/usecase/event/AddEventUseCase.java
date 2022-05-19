package core.usecase.event;

import core.domain.Event;
import core.domain.Orchestra;
import core.usecase.UseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.orchestra.UpdateOrchestraUseCase;

import java.util.Date;

public class AddEventUseCase extends UseCase<AddEventUseCase.InputValues, AddEventUseCase.OutputValues> {


    private final OrchestraRepository orchestraRepo;
    private final EventRepository eventRepo;

    public AddEventUseCase(OrchestraRepository orchestraRepo, EventRepository eventRepo) {
        this.orchestraRepo = orchestraRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (!eventRepo.existsById(input.getEventId())) {
            throw new Exception("This event already exists!");
        }

        Event event=new Event(
                input.getEventId(),
                input.getName(),
                input.getDescription(),
                input.getType(),
                input.getDate()

        );

        Orchestra orchestra=orchestraRepo.getById(input.getOrchestraId());
        orchestra.getEvents().add(event);
        orchestraRepo.save(orchestra);
        eventRepo.save(event);
        return new AddEventUseCase.OutputValues(event);
    }

    public static class InputValues implements UseCase.InputValues {

        private final String name;
        private final String description;
        private final String type;
        private final Date date;
        private final Long eventId;
        private final Long orchestraId;

        public InputValues(String name, String description, String type, Date date, Long eventId, Long orchestraId) {
            this.name = name;
            this.description = description;
            this.type = type;
            this.date = date;
            this.eventId = eventId;
            this.orchestraId = orchestraId;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getType() {
            return type;
        }

        public Date getDate() {
            return date;
        }

        public Long getEventId() {
            return eventId;
        }

        public Long getOrchestraId() {
            return orchestraId;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Event event;

        public OutputValues(Event event) {
            this.event = event;
        }
    }

}
