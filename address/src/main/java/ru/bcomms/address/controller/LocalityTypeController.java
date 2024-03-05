package ru.bcomms.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.LocalityType;
import ru.bcomms.address.service.LocalityTypeService;

@RestController
@RequestMapping(value = "/api/v1/locality-type")
public class LocalityTypeController extends AbstractController<LocalityType, LocalityTypeService> {
    public LocalityTypeController(LocalityTypeService service) {
        super(service);
    }
}
