package ru.bcomms.buildingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.buildingproject.entity.MaterialData;

import java.util.UUID;

@Repository
public interface MaterialDataRepository extends CommonRepository<MaterialData> {
}
