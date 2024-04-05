package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.ProjectInfo;
import ru.bcomms.buildingproject.repository.ProjectInfoRepository;

@Service
public class ProjectInfoService extends CommonService<ProjectInfo, ProjectInfoRepository> {
    public ProjectInfoService(ProjectInfoRepository repository) {
        super(repository);
    }
}
