package ru.bcomms.organizationandrepresentative.service;


import org.springframework.stereotype.Service;
import ru.bcomms.organizationandrepresentative.entity.Sro;
import ru.bcomms.organizationandrepresentative.repository.SroRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class SroService {
    private final SroRepository repository;

    public SroService(SroRepository repository) {
        this.repository = repository;
    }

    public Sro save(Sro entity) {
        return repository.save(entity);
    }

    public Optional<Sro> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<Sro> findAll() {
        return repository.findAll();
    }

    public Sro update(Sro entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
