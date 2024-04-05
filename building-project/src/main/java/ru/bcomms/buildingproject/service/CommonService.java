package ru.bcomms.buildingproject.service;

import ru.bcomms.buildingproject.entity.CommonEntity;
import ru.bcomms.buildingproject.repository.CommonRepository;

import java.util.Optional;
import java.util.UUID;

public abstract class CommonService <E extends CommonEntity, R extends CommonRepository<E>> {
    private final R repository;

    public CommonService(R repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public Optional<E> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<E> findAll() {
        return repository.findAll();
    }

    public Optional<E> update(E entity) {
        return repository
                .findById(entity.getUuid())
                .map((value) -> repository.save(entity));
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
