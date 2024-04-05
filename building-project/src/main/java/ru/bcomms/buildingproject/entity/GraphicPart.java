package ru.bcomms.buildingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Описание комплексного типа GraphicPart
 * Графическая часть проекта
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class GraphicPart extends CommonEntity {
    /**
     * Порядковый номер ревизии проекта
     */
    @ManyToOne
    protected RevisionInfo revisionInfo;
    /**
     * Список ссылок на графические документы
     */
    @ElementCollection
    protected List<UUID> attachmentList = new ArrayList<>();
}
