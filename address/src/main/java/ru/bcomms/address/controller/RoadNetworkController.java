package ru.bcomms.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.RoadNetwork;
import ru.bcomms.address.service.RoadNetworkService;

@RestController
@RequestMapping(value = "/api/v1/road-network")
public class RoadNetworkController extends AbstractController<RoadNetwork, RoadNetworkService> {
    public RoadNetworkController(RoadNetworkService service) {
        super(service);
    }
}
