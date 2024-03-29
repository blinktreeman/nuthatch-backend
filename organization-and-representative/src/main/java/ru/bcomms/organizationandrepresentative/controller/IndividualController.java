package ru.bcomms.organizationandrepresentative.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.organizationandrepresentative.entity.Individual;
import ru.bcomms.organizationandrepresentative.service.IndividualService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/individual")
public class IndividualController {
    private final IndividualService service;

    @Autowired
    public IndividualController(IndividualService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Individual> save(@RequestBody Individual entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Individual> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<Individual>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Individual> update(@RequestBody Individual entity) {
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
