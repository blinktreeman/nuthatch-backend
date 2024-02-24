package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
     * Документы, подтверждающие качество конкретного количества материала
     * (партии, штуки, комплекта, серии и т.п.).
     * Необязательный элемент
     */
    @ElementCollection(targetClass = UUID.class)
    private Set<UUID> materialAmountQualityDocument = new HashSet<>();
    /**
     * Документы, подтверждающие соответствие конкретной номенклатуры материала
     * (изделия), конкретного производителя требуемым параметрам.
     * Обязательный элемент
     */
    @ElementCollection(targetClass = UUID.class)
    private Set<UUID> parametersComplianceDocument = new HashSet<>();
    /**
     * Документы, подтверждающие соответствие конкретной номенклатуры материала (изделия),
     * конкретного производителя дополнительным показателям качества (пожаробезопасность,
     * санитарная, радиационная безопасность и т.д.).
     * Необязательный элемент
     */
    @ElementCollection(targetClass = UUID.class)
    private Set<UUID> additionalParametersComplianceDocument = new HashSet<>();
    /**
     * Документ о результатах дополнительного подтверждения качества конкретного количества
     * материала (партии, штуки, комплекта, серии и т.п.), предназначенного к использованию
     * на конкретном строительном Объекте, путём лабраторных исследований, испытаний и т.п.
     * Необязательный элемент
     */
    @ElementCollection(targetClass = UUID.class)
    private Set<UUID> additionalQualityDocument = new HashSet<>();
}
