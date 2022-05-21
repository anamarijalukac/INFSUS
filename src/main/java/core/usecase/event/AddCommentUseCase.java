package core.usecase.event;

import core.domain.Comment;
import core.domain.Event;
import core.usecase.UseCase;
import lombok.Value;

public class AddCommentUseCase extends UseCase<AddCommentUseCase.InputValues, AddCommentUseCase.OutputValues> {

    private final EventRepository eventRepo;

    public AddCommentUseCase(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Comment comment = new Comment();
        comment.setCommentText(input.getCommentText());

        Event e = eventRepo.getEventById(input.getEventId());
        e.getComments().add(comment);
        eventRepo.save(e);

        return new AddCommentUseCase.OutputValues(comment);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String commentText;
        String commentatorName;
        Long commentId;
        Long eventId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Comment comment;
    }
}
