package ru.bcomms.address.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.address.entity.AbstractEntity;
import ru.bcomms.address.service.CommonService;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public abstract class AbstractController<E extends AbstractEntity,  S extends CommonService<E>> {
    private final S service;

    public AbstractController(S service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<E> save(@RequestBody E entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<E> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<E>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E entity) {
        return new ResponseEntity<>(service.update(entity), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteById(@RequestParam UUID uuid) {
        service.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/all")
    public ResponseEntity<HttpStatus> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
