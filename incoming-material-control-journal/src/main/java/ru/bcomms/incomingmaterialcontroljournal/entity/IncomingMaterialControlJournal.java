package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Описание комплексного типа: IncomingMaterialControlJournal.
 * Журнал входного контроля
 */
@Data
@Entity
public class IncomingMaterialControlJournal implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Информация об UUID и редакции документа, UUID объекта капитального строительства, версии схемы.
     * Обязательный элемент
     */
    @Embedded
    private BaseDocument baseDocument;
    /**
     * Титульный лист. Обязательный элемент
     */
    @ManyToOne
    private IncomingMaterialControlJournalTitle incomingMaterialControlJournalTitle;
    /**
     * Верификация закупленной продукции (список результатов процедур входного контроля материалов).
     * Обязательный элемент
     * Список/Set
     */
    @OneToMany
    private Set<MaterialsOrItemsVerificationRecord> materialsOrItemsVerificationRecords = new HashSet<>();
}
