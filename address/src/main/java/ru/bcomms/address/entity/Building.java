package ru.bcomms.address.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Описание комплексного типа: Building
 * Тип и номер здания (сооружения)
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "building_type", column = @Column(name = "building_building_type")),
        @AttributeOverride(name = "building_number", column = @Column(name = "building_building_number"))
})
public class Building {
    /**
     * Тип здания (сооружения)
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String buildingType;
    /**
     * Номер здания (сооружения)
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String buildingNumber;
}
