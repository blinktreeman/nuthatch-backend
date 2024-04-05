package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.VolumeSheet;
import ru.bcomms.buildingproject.repository.VolumeSheetRepository;

@Service
public class VolumeSheetService extends CommonService<VolumeSheet, VolumeSheetRepository> {
    public VolumeSheetService(VolumeSheetRepository repository) {
        super(repository);
    }
}
