package ru.bcomms.address.service;

import ru.bcomms.address.entity.AbstractEntity;
import ru.bcomms.address.repository.CommonRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    private final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<E> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E update(E entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
