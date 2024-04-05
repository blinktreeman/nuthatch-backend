package ru.bcomms.buildingproject.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

/**
 * Описание комплексного типа RevisionInfo
 * информация о ревизии (изм.) проектной документации
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class RevisionInfo extends CommonEntity {
    /**
     * Порядковый номер изменения
     */
    protected String revisionNumber;
    /**
     * Дата выпуска изменения
     */
    protected Date revisionDate;
    /**
     * Документ о внесении изменений
     */
    protected UUID approvingDocument;
}
