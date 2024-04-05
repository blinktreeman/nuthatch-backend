package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Описание комплексного типа WorkVolumeInfo
 * Данные по объему работ
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "work_volume_info")
public class WorkVolumeInfo extends CommonEntity {
    /**
     * Действующая ревизия проекта
     */
    protected boolean isActive;
    /**
     * Порядковый номер ревизии
     */
    @ManyToOne
    protected RevisionInfo revisionInfo;
    /**
     * Объем работ
     */
    protected String value;
    /**
     * Ссылка на чертеж
     */
    protected String drawingReference;
    /**
     * Формула расчета
     */
    protected String calculationFormula;
}
