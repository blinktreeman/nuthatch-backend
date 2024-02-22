package ru.bcomms.organizationandrepresentative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.IndividualEntrepreneur;
import ru.bcomms.organizationandrepresentative.repository.IndividualEntrepreneurRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class IndividualEntrepreneurService {
    private final IndividualEntrepreneurRepository repository;

    @Autowired
    public IndividualEntrepreneurService(IndividualEntrepreneurRepository repository) {
        this.repository = repository;
    }

    public IndividualEntrepreneur save(IndividualEntrepreneur entity) {
        return repository.save(entity);
    }

    public Optional<IndividualEntrepreneur> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<IndividualEntrepreneur> findAll() {
        return repository.findAll();
    }

    public IndividualEntrepreneur update(IndividualEntrepreneur entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
