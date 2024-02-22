package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: IndividualEntrepreneur.
 * Индивидуальный предприниматель
 */
@Data
@Entity
public class IndividualEntrepreneur implements Serializable {
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
     * Адрес (Почтовый). Обязательный элемент
     */
    private UUID addressUuid;
    /**
     * Основной государственный регистрационный номер индивидуального предпринимателя.
     * Обязательный элемент.
     * Формат:
     * ххххххххххххх
     * 13 цифр
     */
    @Column(nullable = false, length = 13)
    private String ogrnip;
    /**
     * ИНН.
     * Обязательный элемент
     * хххххххххххх
     * 12 цифр
     */
    @Column(nullable = false, length = 12)
    private String inn;
    /**
     * Информация о саморегулируемой организации
     */
    @ManyToOne
    private Sro sro;
}
