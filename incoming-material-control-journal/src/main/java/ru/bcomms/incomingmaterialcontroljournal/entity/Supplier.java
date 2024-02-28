package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: Supplier.
 * Поставщик
 */
@Data
@Entity
public class Supplier implements Serializable {
    /**
     * Id организации.
     * Необязательный элемент
     * Строгий формат:
     * хххххххх-хххх-хххх-хххх-хххххххххххх
     * Наложенные ограничения
     * [0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    @Id
    @GeneratedValue
    private UUID organizationId;
    /**
     * Наименование организации.
     * Обязательный элемент
     * Минимум 1 символ
     */
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, message = "Наименование организации. Минимум 1 символ")
    private String organizationName;
}
