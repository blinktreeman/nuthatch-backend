package ru.bcomms.organizationandrepresentative.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.organizationandrepresentative.entity.OrganisationAndRepresentative;
import ru.bcomms.organizationandrepresentative.service.OrganisationAndRepresentativeService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/organization-and-representative")
public class OrganisationAndRepresentativeController {
    private final OrganisationAndRepresentativeService service;

    @Autowired
    public OrganisationAndRepresentativeController(OrganisationAndRepresentativeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrganisationAndRepresentative> save(@RequestBody
                                                                  OrganisationAndRepresentative entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<OrganisationAndRepresentative> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<OrganisationAndRepresentative>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrganisationAndRepresentative> update(@RequestBody
                                                                    OrganisationAndRepresentative entity) {
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
