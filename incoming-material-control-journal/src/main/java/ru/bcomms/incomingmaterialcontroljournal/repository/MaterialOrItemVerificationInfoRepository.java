package ru.bcomms.incomingmaterialcontroljournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.incomingmaterialcontroljournal.entity.MaterialOrItemVerificationInfo;

import java.util.UUID;

@Repository
public interface MaterialOrItemVerificationInfoRepository extends
        JpaRepository<MaterialOrItemVerificationInfo, UUID> {
}
