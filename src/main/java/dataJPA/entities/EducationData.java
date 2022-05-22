package dataJPA.entities;

import core.domain.Education;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "education")
    private List<UserData> user;

    public EducationData(String name, String level,Long id) {
        this.name = name;
        this.level = level;
        this.id=id;
    }

    public static EducationData from(Education c) {
        return new EducationData(
               c.getName(),c.getLevel(),c.getId()
        );
    }

    public Education fromThis() {
        Education education = new Education();
        education.setId(this.id);
        education.setLevel(this.level);
        education.setName(this.name);
        return education;
    }

    protected EducationData() {
    }
}
