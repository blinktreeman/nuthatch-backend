package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.EntityOfFederation;
import ru.bcomms.address.repository.EntityOfFederationRepository;

@Service
public class EntityOfFederationService extends
        AbstractService<EntityOfFederation, EntityOfFederationRepository> {
    public EntityOfFederationService(EntityOfFederationRepository repository) {
        super(repository);
    }
}
