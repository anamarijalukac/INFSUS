package core.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Song {

    private String name;
    private Date date;
    private String artist;
    private Long id;
}
