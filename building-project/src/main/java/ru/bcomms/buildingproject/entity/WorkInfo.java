package ru.bcomms.buildingproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Описание комплексного типа WorkInfo
 * Вид работ
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class WorkInfo extends CommonEntity {
    /**
     * Порядковый номер
     */
    protected String sheetNumber;
    /**
     * Номер локального сметного расчета
     */
    protected String localEstimateNumber;
    /**
     * Наименование работ
     */
    protected String name;
    /**
     * Единица измерения
     */
    @ManyToOne
    protected Unit unit;
    /**
     * Примечание
     */
    protected String description;
}
