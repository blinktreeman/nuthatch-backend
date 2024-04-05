package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Описание комплексного типа MaterialInfo
 * Данные по применяемому материалу
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class MaterialInfo extends CommonEntity {
    /**
     * Позиция по спецификации
     */
    protected String positionNumber;
    /**
     * Наименование и техническая характеристика
     */
    protected String name;
    /**
     * Тип, марка, обозначение документа опросного листа
     */
    protected String mark;
    /**
     * Код оборудования, изделия и материала
     */
    protected String productCode;
    /**
     * Завод-изготовитель
     */
    protected String supplier;
    /**
     * Единицы измерения
     */
    @ManyToOne
    protected Unit unit;
    /**
     * Масса единицы, кг
     */
    protected String weight;
    /**
     * Примечание
     */
    protected String description;
}
