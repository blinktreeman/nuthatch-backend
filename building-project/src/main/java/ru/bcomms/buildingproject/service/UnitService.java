package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.Unit;
import ru.bcomms.buildingproject.repository.UnitRepository;

@Service
public class UnitService extends CommonService<Unit, UnitRepository> {
    public UnitService(UnitRepository repository) {
        super(repository);
    }
}
