package presenter.rest.api.entities;

import core.domain.Comment;
import lombok.Value;

@Value
public class CommentResponse {
    Long id;
    String commentText;
    String commentatorName;

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getCommentText(),
                comment.getCommentatorName()
        );
    }
}
