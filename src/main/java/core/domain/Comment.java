package core.domain;

public class Comment {

    private String commentText;
    private String commentatorName;

    public Comment(String commentText, String commentatorName) {
        this.commentText = commentText;
        this.commentatorName = commentatorName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName;
    }
}
