package ru.bcomms.address.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Описание комплексного типа: PlanningStructure
 * Наименование элемента планировочной структуры
 */
@Data
@Entity
@Table(name = "planning_structure")
public class PlanningStructure implements AbstractEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Наименование элемента планировочной структуры
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String planningStructureElement;
    /**
     * Наименование объекта планировочной структуры
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String planningStructureObject;
}
