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
                input.getCommentatorName(),
                input.getEventId()
        );

        Event e=eventRepo.getEventById(input.getEventId());
        e.getComments().add(comment);
        eventRepo.save(e);

        return new AddCommentUseCase.OutputValues(comment);

    }


    public static class InputValues implements UseCase.InputValues {

        private final String commentText;
        private final String commentatorName;
        private final Long commentId;
        private final Long eventId;


        public InputValues(String commentText, String commentatorName, Long commentId, Long eventId) {
            this.commentText = commentText;
            this.commentatorName = commentatorName;
            this.commentId = commentId;
            this.eventId = eventId;
        }

        public String getCommentText() {
            return commentText;
        }

        public String getCommentatorName() {
            return commentatorName;
        }

        public Long getCommentId() {
            return commentId;
        }

        public Long getEventId() {
            return eventId;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Comment comment;

        public OutputValues(Comment comment) {
            this.comment = comment;
        }
    }
}
