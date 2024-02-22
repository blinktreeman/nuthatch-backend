package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: Individual.
 * Физическое лицо
 */
@Data
@Entity
public class Individual implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * ФИО. Обязательный элемент
     */
    @Embedded
    @Column(nullable = false)
    private FullNameGroup fullNameGroup;
    /**
     * Адрес. Обязательный элемент
     */
    private UUID addressUuid;

    private boolean isRussianFederationCitizen = true;

    @Embedded
    private PassportDetails passportDetails;
}
