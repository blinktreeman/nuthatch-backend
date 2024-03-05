package ru.bcomms.organizationandrepresentative.service;

import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.ValidationResponsibleRepresentative;
import ru.bcomms.organizationandrepresentative.repository.ValidationResponsibleRepresentativeRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class ValidationResponsibleRepresentativeService {
    private final ValidationResponsibleRepresentativeRepository repository;

    public ValidationResponsibleRepresentativeService(ValidationResponsibleRepresentativeRepository repository) {
        this.repository = repository;
    }

    public ValidationResponsibleRepresentative save(ValidationResponsibleRepresentative entity) {
        return repository.save(entity);
    }

    public Optional<ValidationResponsibleRepresentative> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<ValidationResponsibleRepresentative> findAll() {
        return repository.findAll();
    }

    public ValidationResponsibleRepresentative update(ValidationResponsibleRepresentative entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
