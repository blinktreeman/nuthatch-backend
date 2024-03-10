package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: Sro.
 * Группа, содержащая информацию о Саморегулируемой организации (СРО)
 */
@Data
@Entity
public class Sro implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;
    /**
     * Наименование.
     * Обязательный элемент
     */
    @Column(nullable = false)
    protected String name;
    /**
     * Идентификационный номер налогоплательщика.
     * Обязательный элемент
     * хххххххххх(хх)
     * 10 обязательных и 2 необязательных
     */
    @Column(nullable = false, length = 12)
    protected String inn;
    /**
     * Основной государственный регистрационный номер.
     * Обязательный элемент
     * Формат:
     * ххххххххххххх
     * 13 цифр
     */
    @Column(nullable = false, length = 13)
    protected String ogrn;
}
