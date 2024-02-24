package ru.bcomms.documentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.documentservice.entity.SignatureFilesListItem;

import java.util.UUID;
@Repository
public interface SignatureFilesListItemRepository extends JpaRepository<SignatureFilesListItem, UUID> {
}
