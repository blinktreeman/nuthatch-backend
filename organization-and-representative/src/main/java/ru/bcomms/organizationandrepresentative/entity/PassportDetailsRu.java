package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Описание комплексного типа: PassportDetailsRussianFederation.
 * Паспортные данные гражданина РФ
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "series", column = @Column(name = "passport_details_ru_series")),
        @AttributeOverride(name = "number", column = @Column(name = "passport_details_ru_number")),
        @AttributeOverride(name = "dateIssue", column = @Column(name = "passport_details_ru_date_issue"))
})
public class PassportDetailsRu {
    /**
     * Серия.
     * Обязательный элемент
     * 4 знака
     */
    @Column(nullable = false, length = 4)
    private String series;
    /**
     * Номер.
     * Обязательный элемент
     * 6 знаков
     */
    @Column(nullable = false, length = 6)
    private String number;
    /**
     * Дата выдачи.
     * Обязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    @Column(nullable = false)
    private Date dateIssue;
}
