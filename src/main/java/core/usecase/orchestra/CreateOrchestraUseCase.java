package core.usecase.orchestra;

import core.domain.Orchestra;
import core.domain.User;
import core.usecase.UseCase;
import core.usecase.user.CreateUserUseCase;

import java.util.Date;
import java.util.List;

public class CreateOrchestraUseCase extends UseCase<CreateOrchestraUseCase.InputValues, CreateOrchestraUseCase.OutputValues>  {

    private final OrchestraRepository repository;

    public CreateOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) throws Exception {
        if (repository.existsById(input.getOrchestraId())) {
            throw new Exception("Orchestra name already in use!");
        }

        Orchestra orchestra = new Orchestra(
                input.getName(),
                input.getFounded_date(),
                input.getOrchestraId()
        );

        orchestra.setMembers(input.getMembers());
        orchestra.setLeader(input.getLeader());

        input.getLeader().setStatus("LEADER");

        repository.save(orchestra);


        return new CreateOrchestraUseCase.OutputValues(orchestra);
    }


    public static class InputValues implements UseCase.InputValues {
        private final String name;
        private final Date founded_date;
        private final List<User> members;
        private final User leader;
        private final Long orchestraId;

        public InputValues(String name, Date founded_date, List<User> members, User leader, Long orchestraId) {
            this.name = name;
            this.founded_date = founded_date;
            this.members = members;
            this.leader = leader;
            this.orchestraId = orchestraId;
        }

        public String getName() {
            return name;
        }

        public Date getFounded_date() {
            return founded_date;
        }

        public List<User> getMembers() {
            return members;
        }

        public User getLeader() {
            return leader;
        }

        public Long getOrchestraId() {
            return orchestraId;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Orchestra orchestra;

        public OutputValues(Orchestra orchestra) {
            this.orchestra = orchestra;
        }
    }



}
