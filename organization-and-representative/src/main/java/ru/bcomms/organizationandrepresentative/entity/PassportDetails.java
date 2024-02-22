package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Описание комплексного типа: PassportDetails.
 * Паспортные данные
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "passportDetailsRussianFederation",
                column = @Column(name = "passport_details_passport_details_russian_federation")),
        @AttributeOverride(name = "documentDetailsForeign",
                column = @Column(name = "passport_details_document_details_foreign"))
})
public class PassportDetails {
    /**
     * Паспортные данные гражданина РФ
     */
    @Embedded
    private PassportDetailsRu passportDetailsRussianFederation;
    /**
     * Документ подтверждающий личность иностранного гражданина
     */
    @Embedded
    private DocumentDetailsForeign documentDetailsForeign;
}
