package ru.bcomms.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.EntityOfFederation;
import ru.bcomms.address.service.EntityOfFederationService;

@RestController
@RequestMapping(value = "/api/v1/entity-of-federation")
public class EntityOfFederationController extends
        AbstractController<EntityOfFederation, EntityOfFederationService> {
    @Autowired
    public EntityOfFederationController(EntityOfFederationService service) {
        super(service);
    }
}
