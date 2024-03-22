package ru.bcomms.documentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.documentservice.entity.DocumentType;
import ru.bcomms.documentservice.service.DocumentTypeService;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/document-type")
public class DocumentTypeController {
    private final DocumentTypeService service;

    @Autowired
    public DocumentTypeController(DocumentTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DocumentType> save(@RequestBody DocumentType entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<DocumentType> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<DocumentType>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DocumentType> update(@RequestBody DocumentType entity) {
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
