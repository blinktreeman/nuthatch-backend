package ru.bcomms.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.employee.entity.Document;

import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
