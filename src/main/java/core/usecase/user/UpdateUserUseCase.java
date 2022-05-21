package core.usecase.user;

import core.domain.*;
import core.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class UpdateUserUseCase extends UseCase<UpdateUserUseCase.InputValues, UpdateUserUseCase.OutputValues> {

    private final UserRepository repository;

    public UpdateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public OutputValues execute(InputValues input) throws Exception {
        User user=repository.findById(input.getUserId());

        if(input.getName()!=null)
            user.setName(input.getName());
        if(input.getEmail()!=null)
            user.setEmail(input.getEmail());
        if(input.getAddress()!=null)
            user.setAddress(input.getAddress());
        if(input.getPassword()!=null)
            user.setPassword(input.getPassword());
        if(input.getInstrument()!=null)
            user.setInstrument(input.getInstrument());
        if(input.getEducation()!=null)
            user.setEducation(input.getEducation());
        if(input.getRegistrationList()!=null)
            user.setRegistrationList(input.getRegistrationList());
        if(input.getStatus()!=null)
            user.setStatus(input.getStatus());
        if(input.getOrchestra()!=null)
            user.setOrchestra(input.getOrchestra());

        repository.save(user);

        return new UpdateUserUseCase.OutputValues(user);


    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String name;
        String email;
        String address;
        String password;
        Instrument instrument;
        Education education;
        List<Registration> registrationList;
        String status;
        Orchestra orchestra;
        Long userId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        User user;
    }
}
