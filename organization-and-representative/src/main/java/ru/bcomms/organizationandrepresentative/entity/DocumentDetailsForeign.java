package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Описание комплексного типа: DocumentDetailsForeignCitizen.
 * Документ подтверждающий личность иностранного гражданина
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "docName", column = @Column(name = "document_details_foreign_doc_name")),
        @AttributeOverride(name = "series", column = @Column(name = "document_details_foreign_series")),
        @AttributeOverride(name = "number", column = @Column(name = "document_details_foreign_number")),
        @AttributeOverride(name = "dateIssue", column = @Column(name = "document_details_foreign_date_issue"))
})
public class DocumentDetailsForeign {
    /**
     * Наименование документа.
     * Обязательный элемент.
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String docName;
    /**
     * Серия.
     * Необязательный элемент.
     * Минимум 1 символ
     */
    private String series;
    /**
     * Номер.
     * Обязательный элемент.
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String number;
    /**
     * Дата выдачи.
     * Обязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    @Column(nullable = false)
    private Date dateIssue;
}
