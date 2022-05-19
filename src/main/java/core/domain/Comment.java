package core.domain;

public class Comment {

    private String commentText;
    private String commentatorName;
    private Long id;

    public Comment(String commentText, String commentatorName, Long id) {
        this.commentText = commentText;
        this.commentatorName = commentatorName;
        this.id = id;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
