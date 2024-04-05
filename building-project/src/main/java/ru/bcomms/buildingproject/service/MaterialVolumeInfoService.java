package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.MaterialVolumeInfo;
import ru.bcomms.buildingproject.repository.MaterialVolumeInfoRepository;

@Service
public class MaterialVolumeInfoService extends CommonService<MaterialVolumeInfo, MaterialVolumeInfoRepository> {
    public MaterialVolumeInfoService(MaterialVolumeInfoRepository repository) {
        super(repository);
    }
}
