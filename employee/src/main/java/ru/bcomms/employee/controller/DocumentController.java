package ru.bcomms.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.employee.entity.Document;
import ru.bcomms.employee.service.DocumentService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/document")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Document> save(@RequestBody Document document) {
        return new ResponseEntity<>(service.save(document), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Document> findById(@RequestParam UUID uuid) {
        return service
                .findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<Document>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Document> update(@RequestBody Document document) {
        return service
                .update(document)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
