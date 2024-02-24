package ru.bcomms.documentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.documentservice.entity.DocRequisites;

import java.util.UUID;

@Repository
public interface DocRequisitesRepository extends JpaRepository<DocRequisites, UUID> {
}
