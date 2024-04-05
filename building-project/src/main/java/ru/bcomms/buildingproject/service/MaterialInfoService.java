package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.MaterialInfo;
import ru.bcomms.buildingproject.repository.MaterialInfoRepository;

@Service
public class MaterialInfoService extends CommonService<MaterialInfo, MaterialInfoRepository> {
    public MaterialInfoService(MaterialInfoRepository repository) {
        super(repository);
    }
}
