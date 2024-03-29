package ru.bcomms.documentservice.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.UUID;

/**
 * Описание комплексного типа: InternalAttachment.
 * Информация о файле, загруженном в хранилище
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "uuid", column = @Column(name = "internal_attachment_uuid")),
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
    protected UUID uuid;
    /**
     * Имя файла.
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    protected String name;
    /**
     * Описание.
     * Необязательный элемент
     * Минимум 1 символ
     */
    protected String description;
    /**
     * Контрольная сумма файла.
     * Необязательный элемент
     * Минимум 1 символ
     */
    protected String checksum;
}
