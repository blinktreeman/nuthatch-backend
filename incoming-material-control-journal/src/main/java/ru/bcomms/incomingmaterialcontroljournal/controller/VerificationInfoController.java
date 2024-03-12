package ru.bcomms.incomingmaterialcontroljournal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.incomingmaterialcontroljournal.dto.DocumentResponseDto;
import ru.bcomms.incomingmaterialcontroljournal.dto.IndividualEntrepreneurDto;
import ru.bcomms.incomingmaterialcontroljournal.dto.LegalEntityDto;
import ru.bcomms.incomingmaterialcontroljournal.entity.MaterialOrItemVerificationInfo;
import ru.bcomms.incomingmaterialcontroljournal.service.VerificationInfoService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/verification-info")
public class VerificationInfoController {
    private final VerificationInfoService service;

    public VerificationInfoController(VerificationInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MaterialOrItemVerificationInfo> save(
            @RequestBody MaterialOrItemVerificationInfo entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<MaterialOrItemVerificationInfo> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<MaterialOrItemVerificationInfo>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all-legal-entities")
    public ResponseEntity<Iterable<LegalEntityDto>> findAllLegalEntities() {
        return new ResponseEntity<>(this.service.findAllLegalEntities(), HttpStatus.OK);
    }

    @GetMapping(value = "/all-entrepreneurs")
    public ResponseEntity<Iterable<IndividualEntrepreneurDto>> findAllEntrepreneurs() {
        return new ResponseEntity<>(this.service.findAllEntrepreneurs(), HttpStatus.OK);
    }

    @GetMapping(value = "/all-documents")
    public ResponseEntity<Iterable<DocumentResponseDto>> findAllDocuments() {
        return new ResponseEntity<>(this.service.findAllDocuments(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MaterialOrItemVerificationInfo> update(
            @RequestBody MaterialOrItemVerificationInfo entity) {
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
