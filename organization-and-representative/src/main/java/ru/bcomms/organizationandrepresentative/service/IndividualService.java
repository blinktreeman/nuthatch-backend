package ru.bcomms.organizationandrepresentative.service;

import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.Individual;
import ru.bcomms.organizationandrepresentative.repository.IndividualRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class IndividualService {
    private final IndividualRepository repository;

    public IndividualService(IndividualRepository repository) {
        this.repository = repository;
    }

    public Individual save(Individual entity) {
        return repository.save(entity);
    }

    public Optional<Individual> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<Individual> findAll() {
        return repository.findAll();
    }

    public Individual update(Individual entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
