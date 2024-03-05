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
    protected UUID uuid;
    /**
     * ФИО. Обязательный элемент
     */
    @Embedded
    protected FullNameGroup fullNameGroup;
    /**
     * Адрес. Обязательный элемент
     */
    protected UUID addressUuid;

    protected boolean isRussianFederationCitizen = true;

    @Embedded
    protected PassportDetails passportDetails;
}
