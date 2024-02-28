package ru.bcomms.documentservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Описание комплексного типа: DocumentType
 * Группа, содержащая наименование типа документа и поля документа
 */
@Data
@Entity
public class DocumentType implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;

    protected String typeOfDocument;
    protected String description;
    /**
     * Список полей документа
     */
    @ElementCollection(targetClass = String.class)
    protected List<String> documentFields = new ArrayList<>();
}
