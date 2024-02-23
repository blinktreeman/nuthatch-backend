package ru.bcomms.organizationandrepresentative.service;

import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.DocRequisites;
import ru.bcomms.organizationandrepresentative.repository.DocRequisitesRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class DocRequisitesService {
    private final DocRequisitesRepository repository;

    public DocRequisitesService(DocRequisitesRepository repository) {
        this.repository = repository;
    }

    public DocRequisites save(DocRequisites entity) {
        return repository.save(entity);
    }

    public Optional<DocRequisites> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<DocRequisites> findAll() {
        return repository.findAll();
    }

    public DocRequisites update(DocRequisites entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
