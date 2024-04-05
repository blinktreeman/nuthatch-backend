package ru.bcomms.buildingproject.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Единицы измерения величин ведомости объемов, спецификаций
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Unit extends CommonEntity {
    protected String unit;
}
