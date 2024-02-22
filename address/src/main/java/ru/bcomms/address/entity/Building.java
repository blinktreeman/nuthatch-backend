package ru.bcomms.address.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

/**
 * Описание комплексного типа: Building
 * Тип и номер здания (сооружения)
 */
@Data
@Entity
public class Building implements AbstractEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
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
