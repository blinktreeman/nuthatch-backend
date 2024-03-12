package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Описание комплексного типа: IncomingMaterialControlJournalTitle.
 * Титульный лист
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "permanent_object_info",
                column = @Column(name = "incoming_material_control_journal_title_permanent_object_info")),
        @AttributeOverride(name = "organization_and_representative",
                column = @Column(name = "incoming_material_control_journal_title_organization_and_representative"))
})
public class IncomingMaterialControlJournalTitle {
    /**
     * Сведения об объекте строительства
     */
    @NotNull
    @Column(nullable = false)
    // TODO: building-object-service
    // protected UUID permanentObjectInfo;
    protected String permanentObjectInfo;
    /**
     * Список организаций и их представителей, выполняющих входной контроль материалов.
     * Обязательный элемент
     * Список/Set
     */
    @ElementCollection(targetClass = UUID.class)
    protected Set<UUID> organizationAndRepresentative = new HashSet<>();
}
