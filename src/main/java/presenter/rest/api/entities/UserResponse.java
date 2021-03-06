package presenter.rest.api.entities;

import core.domain.User;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Value
public class UserResponse {
    Long id;
    String name;
    String email;
    String address;
    String password;
    InstrumentResponse instrument;
    EducationResponse education;
    List<RegistrationResponse> registrationList;
    String status;
    OrchestraResponse orchestra;

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getPassword(),
                InstrumentResponse.from(user.getInstrument()),
                EducationResponse.from(user.getEducation()),
                emptyIfNull(user.getRegistrationList()).stream().map(RegistrationResponse::from).collect(Collectors.toList()),
                user.getStatus(),
                null
//                OrchestraResponse.from(user.getOrchestra())
        );
    }
}
