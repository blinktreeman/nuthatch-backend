package ru.bcomms.incomingmaterialcontroljournal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.incomingmaterialcontroljournal.dto.RepresentativeDto;
import ru.bcomms.incomingmaterialcontroljournal.entity.IncomingMaterialControlJournal;
import ru.bcomms.incomingmaterialcontroljournal.entity.MaterialOrItemVerificationInfo;
import ru.bcomms.incomingmaterialcontroljournal.service.JournalService;

import java.util.UUID;

//@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/journal")
public class JournalController {
    private final JournalService service;

    public JournalController(JournalService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_realm_technical-department-engineer')")
    public ResponseEntity<IncomingMaterialControlJournal> save(
            @RequestBody IncomingMaterialControlJournal entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<IncomingMaterialControlJournal> findById(@RequestParam UUID uuid) {
        return service.findById(uuid)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<IncomingMaterialControlJournal>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all-representatives")
    public ResponseEntity<Iterable<RepresentativeDto>> findAllLegalEntities() {
        return new ResponseEntity<>(this.service.findAllRepresentatives(), HttpStatus.OK);
    }

    @GetMapping(value = "/verification-infos")
    public ResponseEntity<Iterable<MaterialOrItemVerificationInfo>> findAllById(
            @RequestParam(name = "uuid") UUID uuid) {
        return null;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_realm_technical-department-engineer')")
    public ResponseEntity<IncomingMaterialControlJournal> update(
            @RequestBody IncomingMaterialControlJournal entity) {
        return new ResponseEntity<>(service.update(entity), HttpStatus.OK);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_realm_technical-department-engineer')")
    public ResponseEntity<HttpStatus> deleteById(@RequestParam UUID uuid) {
        service.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/all")
    @PreAuthorize("hasAuthority('ROLE_realm_technical-department-engineer')")
    public ResponseEntity<HttpStatus> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
