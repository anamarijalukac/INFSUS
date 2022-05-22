package dataJPA.entities;


import core.domain.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "comment")
@Table(name = "comment")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CommentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentText;
    @Column(nullable = false)
    private String commentatorName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private EventData event;

    public static CommentData from(Comment c) {
        CommentData commentData = new CommentData();
        commentData.setCommentText(c.getCommentText());
        commentData.setCommentatorName(c.getCommentatorName());
        commentData.setId(c.getId());
        return commentData;
    }

    public Comment fromThis() {
        Comment comment = new Comment();
        comment.setCommentText(this.getCommentText());
        comment.setCommentatorName(this.getCommentatorName());
        comment.setId(this.getId());
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommentData that = (CommentData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
