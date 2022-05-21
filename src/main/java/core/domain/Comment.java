package core.domain;

import lombok.Data;

@Data
public class Comment {

    private Long id;
    private String commentText;
    private String commentatorName;
}
