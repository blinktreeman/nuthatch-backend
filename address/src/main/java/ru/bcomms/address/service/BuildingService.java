package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.Building;
import ru.bcomms.address.repository.BuildingRepository;

@Service
public class BuildingService extends AbstractService<Building, BuildingRepository> {
    public BuildingService(BuildingRepository repository) {
        super(repository);
    }
}
