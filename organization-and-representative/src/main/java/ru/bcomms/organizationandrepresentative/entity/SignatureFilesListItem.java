package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: SignatureFilesListItem.
 * Файл подписи документа
 */
@Data
@Entity
public class SignatureFilesListItem implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Файл подписи документа. Обязательный элемент
     */
    @Embedded
    private InternalAttachment signatureFilesListItem;
}
