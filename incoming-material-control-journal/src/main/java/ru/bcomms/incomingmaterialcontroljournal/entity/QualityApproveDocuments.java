package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    @Embedded
    protected UntypedQualityApproveDocument untypedQualityApproveDocument;
    /**
     * Комплект типизированных ДПК
     */
    @Embedded
    protected TypedQualityApproveDocument typedQualityApproveDocuments;
}
