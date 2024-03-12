package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Embeddable
@AttributeOverride(name = "untyped_quality_approve_documents_list",
        column = @Column(name = "untyped_quality_approve_document_untyped_quality_approve_documents_list"))
public class UntypedQualityApproveDocument {
    /**
     * Список нетипизированных ДПК
     */
    @ElementCollection
    protected Set<UUID> untypedQualityApproveDocuments = new HashSet<>();
}
