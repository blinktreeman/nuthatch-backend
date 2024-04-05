package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.WorkInfo;
import ru.bcomms.buildingproject.repository.WorkInfoRepository;

@Service
public class WorkInfoService extends CommonService<WorkInfo, WorkInfoRepository> {
    public WorkInfoService(WorkInfoRepository repository) {
        super(repository);
    }
}
