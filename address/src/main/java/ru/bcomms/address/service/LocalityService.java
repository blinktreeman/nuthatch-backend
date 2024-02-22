package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.Locality;
import ru.bcomms.address.repository.LocalityRepository;

@Service
public class LocalityService extends AbstractService<Locality, LocalityRepository> {
    public LocalityService(LocalityRepository repository) {
        super(repository);
    }
}
