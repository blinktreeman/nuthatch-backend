package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.MaterialData;
import ru.bcomms.buildingproject.repository.MaterialDataRepository;

@Service
public class MaterialDataService extends CommonService<MaterialData, MaterialDataRepository> {
    public MaterialDataService(MaterialDataRepository repository) {
        super(repository);
    }
}
