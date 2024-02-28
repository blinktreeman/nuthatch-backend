package ru.bcomms.documentservice.service;

import org.springframework.stereotype.Service;
import ru.bcomms.documentservice.entity.DocumentType;
import ru.bcomms.documentservice.repository.DocumentTypeRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentTypeService {
    private final DocumentTypeRepository repository;

    public DocumentTypeService(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    public DocumentType save(DocumentType entity) {
        return repository.save(entity);
    }

    public Optional<DocumentType> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<DocumentType> findAll() {
        return repository.findAll();
    }

    public DocumentType update(DocumentType entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
