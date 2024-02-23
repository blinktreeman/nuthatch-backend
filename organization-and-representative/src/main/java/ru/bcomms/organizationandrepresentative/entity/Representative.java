package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private UUID uuid;
    /**
     * Фамилия, Имя, Отчество. Обязательный элемент
     */
    @Embedded
    private FullNameGroup fullNameGroup;
    /**
     * Должность.
     * Обязательный элемент.
     * Минимум 1 символ
     */
    private String position;
}
