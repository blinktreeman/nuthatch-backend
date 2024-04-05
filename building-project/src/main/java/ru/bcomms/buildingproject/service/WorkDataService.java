package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.WorkData;
import ru.bcomms.buildingproject.repository.WorkDataRepository;

@Service
public class WorkDataService extends CommonService<WorkData, WorkDataRepository> {
    public WorkDataService(WorkDataRepository repository) {
        super(repository);
    }
}
