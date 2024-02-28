package ru.bcomms.documentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bcomms.documentservice.dto.CustomDocumentDto;
import ru.bcomms.documentservice.entity.CustomDocument;
import ru.bcomms.documentservice.service.CustomDocumentService;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/document")
public class CustomDocumentController {
    private final CustomDocumentService service;

    @Autowired
    public CustomDocumentController(CustomDocumentService service) {
        this.service = service;
    }

//    @PostMapping(value = "/upload")
//    public ResponseEntity<String> upload(@RequestBody MultipartFile file) throws IOException {
//        return new ResponseEntity<>(service.upload(file), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<CustomDocument> save(@RequestBody CustomDocumentDto entity) throws IOException {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomDocument> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<CustomDocument>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomDocument> update(@RequestBody CustomDocument entity) {
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
