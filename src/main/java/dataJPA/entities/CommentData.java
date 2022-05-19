package dataJPA.entities;


import core.domain.Comment;

import javax.persistence.*;

@Entity(name = "comment")
@Table(name = "comment")
public class CommentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentText;
    @Column(nullable = false)
    private String commentatorName;


    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventData event;

    public CommentData(Long id, String commentText, String commentatorName) {
        this.id = id;
        this.commentText = commentText;
        this.commentatorName = commentatorName;
    }

    protected CommentData() {
    }

    public static CommentData from(Comment c) {
        return new CommentData(
                c.getId(),
                c.getCommentText(), c.getCommentatorName()
        );
    }

    public Comment fromThis() {
        return new Comment(
                this.commentText, this.commentatorName, this.id
        );
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

    public EventData getEvent() {
        return event;
    }

    public void setEvent(EventData event) {
        this.event = event;
    }
}
