package ru.bcomms.organizationandrepresentative.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.organizationandrepresentative.entity.ValidationResponsibleRepresentative;

import java.util.UUID;

@Repository
public interface ValidationResponsibleRepresentativeRepository
        extends JpaRepository<ValidationResponsibleRepresentative, UUID> {
}
