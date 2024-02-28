package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Описание комплексного типа: Weight.
 * Масса
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "unit", column = @Column(name = "weight_unit")),
        @AttributeOverride(name = "value", column = @Column(name = "weight_value"))
})
public class Weight {
    private String unit;
    private Double value;
}
