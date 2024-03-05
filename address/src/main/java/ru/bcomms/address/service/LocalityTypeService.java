package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.LocalityType;
import ru.bcomms.address.repository.LocalityTypeRepository;

@Service
public class LocalityTypeService extends AbstractService<LocalityType, LocalityTypeRepository> {
    public LocalityTypeService(LocalityTypeRepository repository) {
        super(repository);
    }
}
