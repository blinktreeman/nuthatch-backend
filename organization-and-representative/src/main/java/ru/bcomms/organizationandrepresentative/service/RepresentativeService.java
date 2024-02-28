package ru.bcomms.organizationandrepresentative.service;

import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.Representative;
import ru.bcomms.organizationandrepresentative.repository.RepresentativeRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class RepresentativeService {
    private final RepresentativeRepository repository;

    public RepresentativeService(RepresentativeRepository repository) {
        this.repository = repository;
    }

    public Representative save(Representative entity) {
        return repository.save(entity);
    }

    public Optional<Representative> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<Representative> findAll() {
        return repository.findAll();
    }

    public Representative update(Representative entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
