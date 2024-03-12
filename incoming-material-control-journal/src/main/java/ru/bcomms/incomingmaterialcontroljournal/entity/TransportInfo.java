package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * Описание комплексного типа: TransportInfo.
 * Информация о транспорте
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "transportType",
                column = @Column(name = "transport_info_transport_type")),
        @AttributeOverride(name = "transportNumber",
                column = @Column(name = "transport_info_transport_number"))
})
public class TransportInfo {
    /**
     * Тип транспорта
     */
    protected String transportType;
    /**
     * Номер
     */
    protected String transportNumber;
}
