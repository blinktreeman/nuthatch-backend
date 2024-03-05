package ru.bcomms.organizationandrepresentative.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.organizationandrepresentative.entity.ValidationResponsibleRepresentative;
import ru.bcomms.organizationandrepresentative.service.ValidationResponsibleRepresentativeService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/validation-responsible-representative")
public class ValidationResponsibleRepresentativeController {
    private final ValidationResponsibleRepresentativeService service;

    @Autowired
    public ValidationResponsibleRepresentativeController(
            ValidationResponsibleRepresentativeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ValidationResponsibleRepresentative> save(
            @RequestBody ValidationResponsibleRepresentative entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ValidationResponsibleRepresentative> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<ValidationResponsibleRepresentative>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ValidationResponsibleRepresentative> update(
            @RequestBody ValidationResponsibleRepresentative entity) {
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
