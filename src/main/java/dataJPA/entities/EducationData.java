package dataJPA.entities;

import core.domain.Comment;
import core.domain.Education;
import core.domain.User;

import javax.persistence.*;

@Entity(name = "education")
@Table(name = "education")
public class EducationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String level;

    @OneToOne(mappedBy = "education")
    private UserData user;

    public EducationData(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public static EducationData from(Education c) {
        return new EducationData(
               c.getName(),c.getLevel()
        );
    }

    public Education fromThis() {
        return new Education(
                this.name,this.level
        );
    }

    protected EducationData() {
    }
}
