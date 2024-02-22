package ru.bcomms.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.Building;
import ru.bcomms.address.service.BuildingService;

@RestController
@RequestMapping(value = "/api/v1/building")
public class BuildingController extends AbstractController<Building, BuildingService> {
    public BuildingController(BuildingService service) {
        super(service);
    }
}
