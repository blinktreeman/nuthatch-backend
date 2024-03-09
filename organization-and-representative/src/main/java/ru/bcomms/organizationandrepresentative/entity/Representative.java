package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: Representative.
 * Представитель, имеющий ФИО, должность
 */
@Data
@Entity
public class Representative implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;
    /**
     * Фамилия, Имя, Отчество. Обязательный элемент
     */
    @Embedded
    protected FullNameGroup fullNameGroup;
    /**
     * Наименование юр. лица.
     */
    @ManyToOne
    protected LegalEntity legalEntity;
    /**
     * Наименование ИП
     */
    @ManyToOne
    protected IndividualEntrepreneur individualEntrepreneur;
    /**
     * Должность.
     * Обязательный элемент.
     * Минимум 1 символ
     */
    protected String position;
    /**
     * Номер специалиста в реестре Нострой
     */
    protected String nostroyNumber;
}
