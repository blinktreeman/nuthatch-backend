package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.WorkVolumeInfo;
import ru.bcomms.buildingproject.repository.WorkVolumeInfoRepository;

@Service
public class WorkVolumeInfoService extends CommonService<WorkVolumeInfo, WorkVolumeInfoRepository> {
    public WorkVolumeInfoService(WorkVolumeInfoRepository repository) {
        super(repository);
    }
}
