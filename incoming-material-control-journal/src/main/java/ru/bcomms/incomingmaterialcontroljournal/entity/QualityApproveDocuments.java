package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Описание комплексного типа: QualityApproveDocuments.
 * Комплект документов, подтверждающих качество (ДПК), на указанный материал (изделие)
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "untypedQualityApproveDocuments",
                column = @Column(name = "quality_approve_documents_untyped_quality_approve_documents")),
        @AttributeOverride(
                name = "typedQualityApproveDocuments",
                column = @Column(name = "quality_approve_documents_typed_quality_approve_documents"))
})
public class QualityApproveDocuments {
    /**
     * Список нетипизированных ДПК
     */
    private Set<UntypedQualityApproveDocument> untypedQualityApproveDocuments = new HashSet<>();
    /**
     * Комплект типизированных ДПК
     */
    private Set<TypedQualityApproveDocument> typedQualityApproveDocuments = new HashSet<>();
}
