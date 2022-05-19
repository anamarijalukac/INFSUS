package dataJPA.repositories.impl;

import core.domain.Registration;
import core.usecase.registration.RegistrationRepository;
import dataJPA.entities.OrchestraData;
import dataJPA.entities.RegistrationData;
import dataJPA.repositories.interfaces.JpaOrchestraRepository;
import dataJPA.repositories.interfaces.JpaRegistrationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {
    private final JpaRegistrationRepository repository;

    public RegistrationRepositoryImpl(JpaRegistrationRepository repository) {
        this.repository = repository;
    }



    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Registration findById(Long id) {

        return repository.findById(id).get().fromThis();
    }



    @Override
    public Registration save(Registration registration) {
        final RegistrationData registrationData = RegistrationData.from(registration);
        return repository.save(registrationData).fromThis();
    }
}
