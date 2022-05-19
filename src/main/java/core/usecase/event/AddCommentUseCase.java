package core.usecase.event;

import core.domain.Comment;
import core.domain.Event;
import core.usecase.UseCase;

public class AddCommentUseCase extends UseCase<AddCommentUseCase.InputValues, AddCommentUseCase.OutputValues> {

    private final EventRepository eventRepo;

    public AddCommentUseCase(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        Comment comment=new Comment(
                input.getCommentText(),
                input.getCommentatorName()
        );

        Event e=eventRepo.findByName(input.event.getName());
        e.getComments().add(comment);
        eventRepo.save(e);

        return new AddCommentUseCase.OutputValues(comment);

    }


    public static class InputValues implements UseCase.InputValues {

        private final String commentText;
        private final String commentatorName;
        private final Event event;

        public InputValues(String commentText, String commentatorName, Event event) {
            this.commentText = commentText;
            this.commentatorName = commentatorName;
            this.event = event;
        }

        public String getCommentText() {
            return commentText;
        }

        public String getCommentatorName() {
            return commentatorName;
        }

        public Event getEvent() {
            return event;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Comment comment;

        public OutputValues(Comment comment) {
            this.comment = comment;
        }
    }
}
