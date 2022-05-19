package core.usecase.user;

import core.domain.*;
import core.usecase.UseCase;
import core.usecase.orchestra.OrchestraRepository;
import core.usecase.orchestra.UpdateOrchestraUseCase;

import java.util.List;
import java.util.Optional;

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

    public static class InputValues implements UseCase.InputValues {
        private String name=null;
        private String email=null;
        private String address=null;
        private String password=null;
        private Instrument instrument=null;
        private Education education=null;
        private List<Registration> registrationList=null;
        private String status=null;
        private Orchestra orchestra=null;
        private final Long userId;

        public InputValues(Long userId) {
            this.userId = userId;
        }

        public Long getUserId() {
            return userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Instrument getInstrument() {
            return instrument;
        }

        public void setInstrument(Instrument instrument) {
            this.instrument = instrument;
        }

        public Education getEducation() {
            return education;
        }

        public void setEducation(Education education) {
            this.education = education;
        }

        public List<Registration> getRegistrationList() {
            return registrationList;
        }

        public void setRegistrationList(List<Registration> registrationList) {
            this.registrationList = registrationList;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Orchestra getOrchestra() {
            return orchestra;
        }

        public void setOrchestra(Orchestra orchestra) {
            this.orchestra = orchestra;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final User user;

        public OutputValues(User user) {
            this.user = user;
        }
    }
}
