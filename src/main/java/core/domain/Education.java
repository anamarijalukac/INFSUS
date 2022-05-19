package core.domain;

public class Education {

    private String name;
    private String level;
    private Long id;

    public Education(String name, String level, Long id) {
        this.name = name;
        this.level = level;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
