package ru.bcomms.buildingobject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.buildingobject.entity.PermanentObjectInfo;

import java.util.UUID;

@Repository
public interface PermanentObjectInfoRepository extends JpaRepository<PermanentObjectInfo, UUID> {
}
