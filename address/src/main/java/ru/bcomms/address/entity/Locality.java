package ru.bcomms.address.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Описание комплексного типа: Locality
 * Тип и наименование населенного пункта
 */
@Data
@Entity
public class Locality implements AbstractEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Тип населенного пункта
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String localityType;
    /**
     * Наименование населенного пункта
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String localityName;
}
