package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Описание комплексного типа Specification
 * Спецификация
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "specification")
public class Specification extends CommonEntity {
    /**
     * Шифр спецификации
     */
    protected String code;
    /**
     * Список материалов, изделий и оборудования
     */
    @OneToMany
    @JoinColumn(name = "specification_uuid", nullable = false)
    @OrderColumn(name = "material_data_uuid", nullable = false)
    protected List<MaterialData> materialDataList = new ArrayList<>();
}
