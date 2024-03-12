package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Описание комплексного типа: TypedQualityApproveDocument.
 * Комплект типизированных ДПК
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "material_amount_quality_document",
                column = @Column(name = "typed_quality_approve_document_material_amount_quality_document")),
        @AttributeOverride(name = "parameters_compliance_document",
                column = @Column(name = "typed_quality_approve_document_parameters_compliance_document")),
        @AttributeOverride(name = "additional_parameters_compliance_document",
                column = @Column(name = "typed_quality_approve_document_additional_parameters_compliance_document")),
        @AttributeOverride(name = "additional_quality_document",
                column = @Column(name = "typed_quality_approve_document_additional_quality_document")),
})
public class TypedQualityApproveDocument {
    // document-service CustomDocument UUIDs
    /**
     * Документ, подтверждающий качество конкретного количества материала
     * (партии, штуки, комплекта, серии и т.п.).
     * Необязательный элемент
     */
    private UUID materialAmountQualityDocument;
    /**
     * Документ, подтверждающий соответствие конкретной номенклатуры материала
     * (изделия), конкретного производителя требуемым параметрам.
     * Обязательный элемент
     */
    private UUID parametersComplianceDocument;
    /**
     * Документ, подтверждающий соответствие конкретной номенклатуры материала (изделия),
     * конкретного производителя дополнительным показателям качества (пожаробезопасность,
     * санитарная, радиационная безопасность и т.д.).
     * Необязательный элемент
     */
    private UUID additionalParametersComplianceDocument;
    /**
     * Документ о результатах дополнительного подтверждения качества конкретного количества
     * материала (партии, штуки, комплекта, серии и т.п.), предназначенного к использованию
     * на конкретном строительном Объекте, путём лабраторных исследований, испытаний и т.п.
     * Необязательный элемент
     */
    private UUID additionalQualityDocument;
}
