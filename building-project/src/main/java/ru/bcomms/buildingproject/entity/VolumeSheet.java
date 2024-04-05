package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Описание комплексного типа VolumeSheet
 * Ведомость объемов работ
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "volume_sheet")
public class VolumeSheet extends CommonEntity {
    /**
     * Шифр ведомости
     */
    protected String code;
    /**
     * Список работ по ведомости по отдельным ревизиям проекта
     */
    @OneToMany
    @JoinColumn(name = "volume_sheet_uuid", nullable = false)
    @OrderColumn(name = "work_data_uuid", nullable = false)
    protected List<WorkData> workDataList = new ArrayList<>();
}
