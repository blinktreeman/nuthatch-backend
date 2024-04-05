package ru.bcomms.buildingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.buildingproject.entity.WorkVolumeInfo;

import java.util.UUID;

@Repository
public interface WorkVolumeInfoRepository extends CommonRepository<WorkVolumeInfo> {
}
