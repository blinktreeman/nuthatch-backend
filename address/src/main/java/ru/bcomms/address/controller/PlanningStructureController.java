package ru.bcomms.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.PlanningStructure;
import ru.bcomms.address.service.PlanningStructureService;

@RestController
@RequestMapping(value = "/api/v1/planning-structure")
public class PlanningStructureController
        extends AbstractController<PlanningStructure, PlanningStructureService> {
    public PlanningStructureController(PlanningStructureService service) {
        super(service);
    }
}
