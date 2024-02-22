package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
    private UUID uuid;
    /**
     * Наименование юр. лица.
     * Обязательный элемент.
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String name;
    /**
     * Основной государственный регистрационный номер.
     * Обязательный элемент.
     * Формат: ххххххххххххх 13 цифр
     */
    @Column(nullable = false, length = 13)
    private String ogrn;
    /**
     * Идентификационный номер налогоплательщика.
     * Обязательный элемент.
     * хххххххххх(хх)
     * 10 обязательных и 2 необязательных
     */
    @Column(nullable = false, length = 12)
    private String inn;
    /**
     * Адрес (Почтовый).
     * Обязательный элемент
     */
    private UUID address;
    /**
     * Телефон/Факс.
     * Необязательный элемент.
     * Минимум 1 символ
     */
    private String phone;
    /**
     * Информация о саморегулируемой организации
     */
    @ManyToOne
    private Sro sro;

    public LegalEntity(String name, String ogrn, String inn) {
        this.name = name;
        this.ogrn = ogrn;
        this.inn = inn;
    }
}
