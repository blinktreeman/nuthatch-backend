package ru.bcomms.documentservice.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Date;

/**
 * Описание комплексного типа: DocInfoGroup
 * Группа, содержащая наименование документа и номер(код/шифр) документа
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "doc_info_group_name")),
        @AttributeOverride(name = "number", column = @Column(name = "doc_info_group_number")),
        @AttributeOverride(name = "date", column = @Column(name = "doc_info_group_date"))
})
public class DocInfoGroup {
    /**
     * Наименование документа.
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String name;
    /**
     * Номер/код/шифр документа.
     * Обязательный элемент
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
    private Date date;
}
