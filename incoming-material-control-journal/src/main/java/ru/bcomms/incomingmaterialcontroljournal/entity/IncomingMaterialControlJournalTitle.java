package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Описание комплексного типа: IncomingMaterialControlJournalTitle.
 * Титульный лист
 */
@Data
@Entity
public class IncomingMaterialControlJournalTitle implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Id объекта капитального строительства.
     * Обязательный элемент
     * Строгий формат:
     * хххххххх-хххх-хххх-хххх-хххххххххххх
     * Наложенные ограничения
     * [0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    @NotNull
    @Column(nullable = false)
    private UUID permanentObjectInfo;
    /**
     * Список организаций и их представителей, выполняющих входной контроль материалов.
     * Обязательный элемент
     * Список/Set
     */
    @ElementCollection(targetClass = UUID.class)
    @CollectionTable(
            name = "journal_organization_and_representative",
            joinColumns = @JoinColumn(name = "journal_uuid")
    )
    private Set<UUID> organisationAndRepresentative = new HashSet<>();
}
