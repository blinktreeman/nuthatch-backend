package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.RevisionInfo;
import ru.bcomms.buildingproject.repository.RevisionInfoRepository;

@Service
public class RevisionInfoService extends CommonService<RevisionInfo, RevisionInfoRepository> {
    public RevisionInfoService(RevisionInfoRepository repository) {
        super(repository);
    }
}
