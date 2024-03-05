package ru.bcomms.address.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Описание комплексного типа: PlanningStructure
 * Наименование элемента планировочной структуры
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "planning_structure_element",
                column = @Column(name = "planning_structure_planning_structure_element")),
        @AttributeOverride(name = "planning_structure_object",
                column = @Column(name = "planning_structure_planning_structure_object"))
})
public class PlanningStructure {
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
