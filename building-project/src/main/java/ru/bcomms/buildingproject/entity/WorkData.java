package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Описание комплексного типа WorkData
 * Данные по выполняемой работе
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "work_data")
public class WorkData extends CommonEntity {
    /**
     * Характеристика выполняемой работы
     */
    @ManyToOne
    protected WorkInfo workInfo;
    /**
     * Объемы выполняемые по отдельным ревизиям проектной ведомости работ
     */
    @OneToMany
    @JoinColumn(name = "work_data_uuid", nullable = false)
    @OrderColumn(name = "work_volume_info_uuid", nullable = false)
    protected List<WorkVolumeInfo> workVolumeInfoList = new ArrayList<>();
}
