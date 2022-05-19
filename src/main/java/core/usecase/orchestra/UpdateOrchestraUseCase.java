package core.usecase.orchestra;

import core.domain.*;
import core.usecase.UseCase;

import java.util.Date;
import java.util.List;

public class UpdateOrchestraUseCase extends UseCase<UpdateOrchestraUseCase.InputValues, UpdateOrchestraUseCase.OutputValues> {

    private final OrchestraRepository repository;


    public UpdateOrchestraUseCase(OrchestraRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Orchestra orchestra=repository.getById(input.getOrchestraId());
        if(input.getName()!=null)
            orchestra.setName(input.getName());

        if(input.getFounded_date()!=null)
            orchestra.setFounded_date(input.getFounded_date());

        if(input.getMembers()!=null)
            orchestra.setMembers(input.getMembers());

        if(input.getLeader()!=null)
            orchestra.setLeader(input.getLeader());

        if(input.getWeb_page()!=null)
            orchestra.setWeb_page(input.getWeb_page());

        if(input.getDiscography()!=null)
            orchestra.setDiscography(input.getDiscography());

        if(input.getEvents()!=null)
            orchestra.setEvents(input.getEvents());

        if(input.getRegistrations()!=null)
            orchestra.setRegistrations(input.getRegistrations());

        repository.save(orchestra);

        return new UpdateOrchestraUseCase.OutputValues(orchestra);
    }




    public static class InputValues implements UseCase.InputValues {
        private  String name=null;
        private  Date founded_date=null;
        private  List<User> members=null;
        private  User leader=null;
        private String web_page=null;
        private Discography discography=null;
        private List<Event> events=null;
        private List<Registration> registrations=null;
        private final Long orchestraId;

        public InputValues(Long orchestraId) {
            this.orchestraId = orchestraId;
        }

        public Long getOrchestraId() {
            return orchestraId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getFounded_date() {
            return founded_date;
        }

        public void setFounded_date(Date founded_date) {
            this.founded_date = founded_date;
        }

        public List<User> getMembers() {
            return members;
        }

        public void setMembers(List<User> members) {
            this.members = members;
        }

        public User getLeader() {
            return leader;
        }

        public void setLeader(User leader) {
            this.leader = leader;
        }

        public String getWeb_page() {
            return web_page;
        }

        public void setWeb_page(String web_page) {
            this.web_page = web_page;
        }

        public Discography getDiscography() {
            return discography;
        }

        public void setDiscography(Discography discography) {
            this.discography = discography;
        }

        public List<Event> getEvents() {
            return events;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }

        public List<Registration> getRegistrations() {
            return registrations;
        }

        public void setRegistrations(List<Registration> registrations) {
            this.registrations = registrations;
        }


    }


    public static class OutputValues implements UseCase.OutputValues {
        private final Orchestra orchestra;

        public OutputValues(Orchestra orchestra) {
            this.orchestra = orchestra;
        }

    }


}
