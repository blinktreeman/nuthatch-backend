package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: LegalEntity.
 * Юридическое лицо
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "legal_entity")
public class LegalEntity implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;
    /**
     * Наименование юр. лица.
     * Обязательный элемент.
     * Минимум 1 символ
     */
    @Column(nullable = false)
    protected String fullName;
    @Column(nullable = false)
    protected String shortName;
    /**
     * Основной государственный регистрационный номер.
     * Обязательный элемент.
     * Формат: ххххххххххххх 13 цифр
     */
    @Column(nullable = false, length = 13)
    protected String ogrn;
    /**
     * Идентификационный номер налогоплательщика.
     * Обязательный элемент.
     * хххххххххх(хх)
     * 10 обязательных и 2 необязательных
     */
    @Column(nullable = false, length = 12)
    protected String inn;
    /**
     * Адрес (Почтовый).
     * Обязательный элемент
     */
    protected UUID addressUuid;
    protected String address;
    /**
     * Телефон/Факс.
     * Необязательный элемент.
     * Минимум 1 символ
     */
    protected String phone;
    /**
     * Информация о саморегулируемой организации
     */
    @ManyToOne
    protected Sro sro;

    public LegalEntity(String name, String ogrn, String inn) {
        this.fullName = name;
        this.ogrn = ogrn;
        this.inn = inn;
    }
}
