package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Описание комплексного типа MaterialVolumeInfo
 * Данные по объему материала для соответствующего изменения
 * проектной документации
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "material_volume_info")
public class MaterialVolumeInfo extends CommonEntity {
    /**
     * Действующая на данный момент ревизия проекта
     */
    protected boolean isActive;
    /**
     * Номер ревизии
     */
    @ManyToOne
    protected RevisionInfo revisionInfo;
    /**
     * Количество
     */
    protected String value;
}
