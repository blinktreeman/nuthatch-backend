package ru.bcomms.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bcomms.employee.entity.Document;
import ru.bcomms.employee.repository.DocumentRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentService {

    private final DocumentRepository repository;

    @Autowired
    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    public Document save(Document document) {
        return repository.save(document);
    }

    public Optional<Document> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<Document> findAll() {
        return repository.findAll();
    }

    public Optional<Document> update(Document document) {
        return repository.findById(document.getUuid()).isPresent() ?
                Optional.of(repository.save(document)) :
                Optional.empty();
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
