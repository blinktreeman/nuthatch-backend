package ru.bcomms.organizationandrepresentative.service;

import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.OrganisationAndRepresentative;
import ru.bcomms.organizationandrepresentative.repository.OrganisationAndRepresentativeRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrganisationAndRepresentativeService {
    private final OrganisationAndRepresentativeRepository repository;

    public OrganisationAndRepresentativeService(OrganisationAndRepresentativeRepository repository) {
        this.repository = repository;
    }

    public OrganisationAndRepresentative save(OrganisationAndRepresentative entity) {
        return repository.save(entity);
    }

    public Optional<OrganisationAndRepresentative> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<OrganisationAndRepresentative> findAll() {
        return repository.findAll();
    }

    public OrganisationAndRepresentative update(OrganisationAndRepresentative entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
