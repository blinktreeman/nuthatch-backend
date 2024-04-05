package ru.bcomms.buildingobject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.buildingobject.entity.PermanentObjectInfo;
import ru.bcomms.buildingobject.service.PermanentObjectInfoService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/permanent-object-info")
public class PermanentObjectInfoController {
    private final PermanentObjectInfoService service;

    @Autowired
    public PermanentObjectInfoController(PermanentObjectInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PermanentObjectInfo> create(@RequestBody PermanentObjectInfo objectInfo) {
        return new ResponseEntity<>(service.save(objectInfo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PermanentObjectInfo> findBuId(@RequestParam(name = "uuid") UUID uuid) {
        return service.findById(uuid)
                .map((value) -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<PermanentObjectInfo>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PermanentObjectInfo> update(@RequestBody PermanentObjectInfo objectInfo) {
        return service.update(objectInfo)
                .map((value) -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteById(@RequestParam(name = "uuid") UUID uuid) {
        service.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/all")
    public ResponseEntity<HttpStatus> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
