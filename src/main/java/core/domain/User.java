package core.domain;


import java.util.List;

public class User {

        private String name;
        private String email;
        private String address;
        private String password;


        private Instrument instrument;
        private Education education;
        private List<Registration> registrationList;
        private String status;
        private Orchestra orchestra;

        public User(String name, String address,String email, String password) {
                this.name = name;
                this.email = email;
                this.password = password;
                this.address=address;
        }

        public Orchestra getOrchestra() {
                return orchestra;
        }

        public void setOrchestra(Orchestra orchestra) {
                this.orchestra = orchestra;
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

        public void addRegistration(Registration r) {
                this.registrationList.add(r);
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}

