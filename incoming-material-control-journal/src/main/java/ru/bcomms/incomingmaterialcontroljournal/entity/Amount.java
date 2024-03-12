package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Описание комплексного типа: Amount.
 * Количество
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "unit", column = @Column(name = "amount_unit")),
        @AttributeOverride(name = "value", column = @Column(name = "amount_value"))
})
public class Amount {
    @NotNull
    @Column(nullable = false)
    protected String unit;
    @NotNull
    @Column(nullable = false)
    protected Double value;
}
