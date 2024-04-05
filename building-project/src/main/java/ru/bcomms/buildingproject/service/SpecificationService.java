package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.Specification;
import ru.bcomms.buildingproject.repository.SpecificationRepository;

@Service
public class SpecificationService extends CommonService<Specification, SpecificationRepository> {
    public SpecificationService(SpecificationRepository repository) {
        super(repository);
    }
}
