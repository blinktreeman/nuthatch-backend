package ru.bcomms.documentservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Описание комплексного типа: CustomDocument.
 * Информация о документе (наименование, номер, дата, срок действия (необяз.),
 * файл документа, массив файлов подписей (необяз.))
 */
@Data
@Entity
public class CustomDocument implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;
    @ManyToOne
    protected DocumentType documentType;
    /**
     * Значения полей documentFields
     */
    @ElementCollection(targetClass = String.class)
    protected List<String> fieldValues = new ArrayList<>();
    /**
     * Дата выдачи.
     * Обязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    protected Date date;
    /**
     * Срок действия.
     * Необязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    protected Date expirationDate;
    /**
     * Файл документа.
     * Обязательный элемент
     */
    @Embedded
    protected InternalAttachment attachment;
}
