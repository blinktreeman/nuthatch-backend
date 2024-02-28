package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: TypedQualityApproveDocument.
 * Комплект типизированных ДПК
 */
@Data
@Entity
public class TypedQualityApproveDocument implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    // document-service DocRequisites UUIDs
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
