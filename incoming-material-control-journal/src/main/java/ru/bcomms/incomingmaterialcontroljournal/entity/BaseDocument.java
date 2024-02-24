package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: BaseDocument.
 * Информация об UUID и редакции документа, UUID объекта капитального строительства, версии схемы
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "schemaVersion",
                column = @Column(name = "base_document_schema_version")),
        @AttributeOverride(name = "uuid",
                column = @Column(name = "base_document_uuid")),
        @AttributeOverride(name = "permanentObjectUuid",
                column = @Column(name = "base_document_permanent_object_uuid")),
        @AttributeOverride(name = "edition",
                column = @Column(name = "base_document_edition")),
})
public class BaseDocument implements Serializable {
    /**
     * Версия схемы.
     * Обязательный элемент.
     * Заполняется шиной (TODO: ?)
     */
    @NotNull
    @Column(nullable = false)
    private String schemaVersion;
    /**
     * UUID документа.
     * Обязательный элемент
     * Строгий формат:
     * хххххххх-хххх-хххx-хххx-хххххххххххх
     * Наложенные ограничения
     * [0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    @NotNull
    @Column(nullable = false)
    private UUID uuid;
    /**
     * UUID объекта капитального строительства.
     * Обязательный элемент
     * Строгий формат:
     * хххххххх-хххх-хххx-хххx-хххххххххххх
     * Наложенные ограничения
     * [0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    @NotNull
    @Column(nullable = false)
    private UUID permanentObjectUuid;
    /**
     * Редакция документа (версия).
     * Обязательный элемент Заполняется ИС (TODO: ?)
     */
    @NotNull
    @Column(nullable = false)
    private String edition;
}
