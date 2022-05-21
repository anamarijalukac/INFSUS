package core.usecase.event;

import core.domain.Comment;
import core.domain.Event;
import core.domain.NotFoundException;
import core.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class GetCommentsUseCase extends UseCase<GetCommentsUseCase.InputValues, GetCommentsUseCase.OutputValues> {

    private final EventRepository repository;

    public GetCommentsUseCase(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        final Long id = input.getEventId();

        Event event = repository.getEventById(id);

        if (event == null) {
            throw new NotFoundException("Event " + id + " not found");
        }

        return new OutputValues(event.getComments());
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long eventId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<Comment> comments;
    }
}
