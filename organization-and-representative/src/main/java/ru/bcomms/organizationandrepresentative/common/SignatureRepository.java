package ru.bcomms.organizationandrepresentative.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SignatureRepository extends JpaRepository<Signature, UUID> {
}
