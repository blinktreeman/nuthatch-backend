package ru.bcomms.documentservice.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
