package ru.bcomms.organizationandrepresentative.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.organizationandrepresentative.entity.IndividualEntrepreneur;
import ru.bcomms.organizationandrepresentative.service.IndividualEntrepreneurService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/individual-entrepreneur")
public class IndividualEntrepreneurController {
    private final IndividualEntrepreneurService service;

    public IndividualEntrepreneurController(IndividualEntrepreneurService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<IndividualEntrepreneur> save(@RequestBody IndividualEntrepreneur entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<IndividualEntrepreneur> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<IndividualEntrepreneur>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<IndividualEntrepreneur> update(@RequestBody IndividualEntrepreneur entity) {
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
