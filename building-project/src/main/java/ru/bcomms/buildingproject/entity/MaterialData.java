package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Описание комплексного типа MaterialData
 * Данные по материалу спецификации
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "material_data")
public class MaterialData extends CommonEntity {
    /**
     * Характеристики материала/оборудования/изделия
     */
    @ManyToOne
    protected MaterialInfo materialInfo;
    /**
     * Данные по объемам материала по отдельным ревизиям документации
     */
    @OneToMany
    @JoinColumn(name = "material_data_uuid", nullable = false)
    @OrderColumn(name = "material_volume_info_uuid", nullable = false)
    protected List<MaterialVolumeInfo> materialVolumeInfoList = new ArrayList<>();
}
