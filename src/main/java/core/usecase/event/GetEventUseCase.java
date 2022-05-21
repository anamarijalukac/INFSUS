package core.usecase.event;

import core.domain.Event;
import core.usecase.UseCase;
import lombok.Value;

public class GetEventUseCase extends UseCase<GetEventUseCase.InputValues, GetEventUseCase.OutputValues> {

    private final EventRepository repository;

    public GetEventUseCase(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        final Long id = input.getEventId();

        Event event = repository.getEventById(id);

        if (event == null) {
            throw new Exception("Event " + id + " not found");
        }

        return new OutputValues(event);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long eventId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Event event;
    }
}
