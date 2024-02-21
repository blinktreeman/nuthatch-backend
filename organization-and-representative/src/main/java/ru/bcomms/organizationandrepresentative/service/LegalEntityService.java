package ru.bcomms.organizationandrepresentative.service;

import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.LegalEntity;
import ru.bcomms.organizationandrepresentative.repository.LegalEntityRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class LegalEntityService {
    private final LegalEntityRepository repository;

    public LegalEntityService(LegalEntityRepository repository) {
        this.repository = repository;
    }

    public LegalEntity save(LegalEntity legalEntity) {
        return repository.save(legalEntity);
    }

    public Optional<LegalEntity> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<LegalEntity> findAll() {
        return repository.findAll();
    }

    public LegalEntity update(LegalEntity legalEntity) {
        return repository.save(legalEntity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
