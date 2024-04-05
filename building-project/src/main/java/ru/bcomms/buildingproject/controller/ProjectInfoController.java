package ru.bcomms.buildingproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.buildingproject.dto.ProjectInfoDto;
import ru.bcomms.buildingproject.entity.ProjectInfo;
import ru.bcomms.buildingproject.service.ProjectInfoService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/project")
public class ProjectInfoController {
    private final ProjectInfoService service;

    public ProjectInfoController(ProjectInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProjectInfo> create(@RequestBody ProjectInfo entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ProjectInfo> findById(@RequestParam(name = "uuid") UUID uuid) {
        return service
                .findById(uuid)
                .map((value) -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<ProjectInfo>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProjectInfo> update(@RequestBody ProjectInfoDto projectInfoDto) {
        return service
                .findById(projectInfoDto.getUuid())
                .map((value) -> {
                    value.setBuildingObject(projectInfoDto.getBuildingObject());
                    value.setTitle(projectInfoDto.getTitle());
                    value.setCode(projectInfoDto.getCode());
                    value.setChiefEngineer(projectInfoDto.getChiefEngineer());
                    return new ResponseEntity<>(service.save(value), HttpStatus.OK);
                })
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
