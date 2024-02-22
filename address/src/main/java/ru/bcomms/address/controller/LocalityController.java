package ru.bcomms.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.Locality;
import ru.bcomms.address.service.LocalityService;

@RestController
@RequestMapping(value = "/api/v1/locality")
public class LocalityController extends AbstractController<Locality, LocalityService> {
    public LocalityController(LocalityService service) {
        super(service);
    }
}
