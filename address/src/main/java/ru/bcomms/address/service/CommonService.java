package ru.bcomms.address.service;

import ru.bcomms.address.entity.AbstractEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.UUID;

public interface CommonService <E extends AbstractEntity> {
    E save(E entity);

    Optional<E> findById(UUID id);

    Iterable<E> findAll();

    E update(E entity);

    void deleteById(UUID id);
    void deleteAll();
}
