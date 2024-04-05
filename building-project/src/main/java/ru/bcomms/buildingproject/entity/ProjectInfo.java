package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Описание комплексного типа ProjectInfo
 * Данные по проекту
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "project_info")
public class ProjectInfo extends CommonEntity {
    /**
     * Ссылка на объект строительства
     */
    protected UUID buildingObject;
    /**
     * Наименование раздела проекта
     */
    protected String title;
    /**
     * Шифр проекта
     */
    protected String code;
    /**
     * Главный инженер проекта
     */
    @Embedded
    protected Person chiefEngineer;
    /**
     * Графическая часть проекта
     */
    @OneToMany
    @JoinColumn(name = "project_info_uuid", nullable = false)
    @OrderColumn(name = "graphic_part_uuid", nullable = false)
    protected List<GraphicPart> graphicPartList = new ArrayList<>();
    /**
     * Ведомости объемов работ
     */
    @OneToMany
    @JoinColumn(name = "project_info_uuid", nullable = false)
    @OrderColumn(name = "volume_sheet_uuid", nullable = false)
    protected List<VolumeSheet> volumeSheetList = new ArrayList<>();
    /**
     * Спецификации проекта
     */
    @OneToMany
    @JoinColumn(name = "project_info_uuid", nullable = false)
    @OrderColumn(name = "specification_uuid", nullable = false)
    protected List<Specification> specificationList = new ArrayList<>();
}
