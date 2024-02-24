package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * Описание комплексного типа: MaterialOrItemVerificationInfoSignedPart.
 * Подписываемая часть сведений о верификации закупленной продукции
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "materialOrItemVerificationJournalRecordId",
                column = @Column(name = "material_verification_info_signed_part_material_or_item_verification_journal_record_id")),
        @AttributeOverride(name = "deliveryDate",
                column = @Column(name = "material_verification_info_signed_part_delivery_date")),
        @AttributeOverride(name = "transportInfo",
                column = @Column(name = "material_verification_info_signed_part_transport_info")),
        @AttributeOverride(name = "supplier",
                column = @Column(name = "material_verification_info_signed_part_supplier")),
        @AttributeOverride(name = "materialOrItemName",
                column = @Column(name = "material_verification_info_signed_part_material_or_item_name")),
        @AttributeOverride(name = "qualityApproveDocuments",
                column = @Column(name = "material_verification_info_signed_part_quality_approve_documents")),
        @AttributeOverride(name = "packagingType",
                column = @Column(name = "material_verification_info_signed_part_packaging_type")),
        @AttributeOverride(name = "materialOrItemAdditionalInfo",
                column = @Column(name = "material_verification_info_signed_part_material_or_item_additional_info")),
        @AttributeOverride(name = "samplingPlace",
                column = @Column(name = "material_verification_info_signed_part_sampling_place")),
        @AttributeOverride(name = "samplingDate",
                column = @Column(name = "material_verification_info_signed_part_sampling_date")),
        @AttributeOverride(name = "qualityConclusion",
                column = @Column(name = "material_verification_info_signed_part_quality_conclusion")),
        @AttributeOverride(name = "id",
                column = @Column(name = "material_verification_info_signed_part_id"))
})
@Table(name = "material_verification_info_signed_part")
public class MaterialOrItemVerificationInfoSignedPart {
    /**
     * Идентификатор записи журнала.
     * Обязательный элемент
     * Строгий формат:
     * хххххххх-хххх-хххх-хххх-хххххххххххх
     * Наложенные ограничения
     * [0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    private UUID materialOrItemVerificationJournalRecordId;
    /**
     * Дата поступления.
     * Обязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    @NotNull
    @Column(nullable = false)
    private Date deliveryDate;
    /**
     * Информация о транспорте.
     * Необязательный элемент
     */
    @Embedded
    private TransportInfo transportInfo;
    /**
     * Поставщик. Обязательный элемент
     */
    @NotNull
    @Column(nullable = false)
    @ManyToOne
    private Supplier supplier;
    /**
     * Наименование материала (изделия), его маркировка.
     * Обязательный элемент
     * Минимум 1 символ
     */
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, message = "Наименование материала (изделия), его маркировка. Минимум 1 символ")
    private String materialOrItemName;
    /**
     * Комплект документов, подтверждающих качество (ДПК) материала (изделия).
     * Обязательный элемент
     */
    @Embedded
    private QualityApproveDocuments qualityApproveDocuments;
    /**
     * Вид упаковки. Необязательный элемент
     * Минимум 1 символ
     */
    private String packagingType;
    /**
     * Масса, партия, количество.
     * Обязательный элемент
     */
    @Embedded
    private MaterialOrItemAdditionalInfo materialOrItemAdditionalInfo;
    /**
     * Место отбора образца (выборки или пробы).
     * Необязательный элемент
     * Минимум 1 символ
     */
    // TODO: Enumerate
    private String samplingPlace;
    /**
     * Дата отбора образца (выборки или пробы).
     * Необязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    private Date samplingDate;
    /**
     * Заключение о качестве.
     * Обязательный элемент
     * Минимум 1 символ
     */
    // TODO: Enumerate
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, message = "Заключение о качестве. Минимум 1 символ")
    private String qualityConclusion;
    /**
     * Id подписываемой части сведений о верификации закупленной продукции.
     * Обязательный элемент
     * Строгий формат:
     * _хххххххх-хххх-хххх-хххх-хххххххххххх
     * Наложенные ограничения
     * _[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    private UUID id;
}
