package ru.bcomms.incomingmaterialcontroljournal.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Описание комплексного типа: MaterialOrItemVerificationInfoSignedPart.
 * Подписываемая часть сведений о верификации закупленной продукции
 */
@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uuid"
)
public class MaterialOrItemVerificationInfo implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;
    /**
     * Журнал входного контроля к которому относится запись
     * о верификации
     */
    @ManyToOne
    protected IncomingMaterialControlJournal incomingMaterialControlJournal;
    /**
     * Дата поступления.
     * Обязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    @NotNull
    @Column(nullable = false)
    protected Date deliveryDate;
    /**
     * Информация о транспорте.
     * Необязательный элемент
     */
    @Embedded
    protected TransportInfo transportInfo;
    /**
     * Поставщик. Обязательный элемент
     */
    protected UUID supplier;
    /**
     * Наименование материала (изделия), его маркировка.
     * Обязательный элемент
     * Минимум 1 символ
     */
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, message = "Наименование материала (изделия), его маркировка. Минимум 1 символ")
    protected String materialOrItemName;
    /**
     * Комплект документов, подтверждающих качество (ДПК) материала (изделия).
     * Обязательный элемент
     */
    @Embedded
    protected QualityApproveDocuments qualityApproveDocuments;
    /**
     * Вид упаковки. Необязательный элемент
     * Минимум 1 символ
     */
    protected String packagingType;
    /**
     * Масса, партия, количество.
     * Обязательный элемент
     */
    @Embedded
    protected MaterialOrItemAdditionalInfo materialOrItemAdditionalInfo;
    /**
     * Место отбора образца (выборки или пробы).
     * Необязательный элемент
     * Минимум 1 символ
     */
    protected String samplingPlace;
    /**
     * Дата отбора образца (выборки или пробы).
     * Необязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    protected Date samplingDate;
    /**
     * Заключение о качестве.
     * Обязательный элемент
     * Минимум 1 символ
     */
    // TODO: Enumerate
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, message = "Заключение о качестве. Минимум 1 символ")
    protected String qualityConclusion;

}
