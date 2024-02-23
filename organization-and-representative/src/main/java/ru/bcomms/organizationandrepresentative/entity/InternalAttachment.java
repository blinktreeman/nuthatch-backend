package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Описание комплексного типа: InternalAttachment.
 * Информация о файле, загруженном в хранилище
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "internal_attachment_id")),
        @AttributeOverride(name = "name", column = @Column(name = "internal_attachment_name")),
        @AttributeOverride(name = "description", column = @Column(name = "internal_attachment_description")),
        @AttributeOverride(name = "checksum", column = @Column(name = "internal_attachment_checksum")),
})
public class InternalAttachment {
    /**
     * Id документа в хранилище.
     * Обязательный элемент
     * Строгий формат:
     * хххххххх-хххх-хххх-хххх-хххххххххххх
     * Наложенные ограничения
     * [0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    private UUID id;
    /**
     * Имя файла.
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String name;
    /**
     * Описание.
     * Необязательный элемент
     * Минимум 1 символ
     */
    private String description;
    /**
     * Контрольная сумма файла.
     * Необязательный элемент
     * Минимум 1 символ
     */
    private String checksum;
}
