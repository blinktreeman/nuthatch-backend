package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Описание комплексного типа: MaterialOrItemAdditionalInfo.
 * Масса, партия, количество
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "weight",
                column = @Column(name = "material_or_item_additional_info_weight")),
        @AttributeOverride(name = "batchNumber",
                column = @Column(name = "material_or_item_additional_info_batchNumber")),
        @AttributeOverride(name = "amount",
                column = @Column(name = "material_or_item_additional_info_amount"))
})
public class MaterialOrItemAdditionalInfo {
    /**
     * Масса. Необязательный элемент
     */
    @Embedded
    protected Weight weight;
    /**
     * Номер партии. Необязательный элемент
     */
    protected String batchNumber;
    /**
     * Количество. Обязательный элемент
     */
    @Embedded
    protected Amount amount;
}
