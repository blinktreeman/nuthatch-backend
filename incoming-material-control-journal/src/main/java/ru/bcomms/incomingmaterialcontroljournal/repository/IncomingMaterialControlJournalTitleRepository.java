package ru.bcomms.incomingmaterialcontroljournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.incomingmaterialcontroljournal.entity.IncomingMaterialControlJournalTitle;

import java.util.UUID;

@Repository
public interface IncomingMaterialControlJournalTitleRepository
        extends JpaRepository<IncomingMaterialControlJournalTitle, UUID> {
}
