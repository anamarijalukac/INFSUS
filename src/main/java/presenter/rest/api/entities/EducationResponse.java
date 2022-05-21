package presenter.rest.api.entities;

import core.domain.Education;
import lombok.Value;

@Value
public class EducationResponse {
    Long id;
    String name;
    String level;

    public static EducationResponse from(Education education) {
        return new EducationResponse(
                education.getId(),
                education.getName(),
                education.getLevel()
        );
    }
}
