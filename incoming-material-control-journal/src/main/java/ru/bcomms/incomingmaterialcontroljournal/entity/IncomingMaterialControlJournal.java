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
    protected UUID uuid;
    /**
     * Титульный лист. Обязательный элемент
     */
    @Embedded
    protected IncomingMaterialControlJournalTitle incomingMaterialControlJournalTitle;
    /**
     * Верификация закупленной продукции (список результатов процедур входного контроля материалов).
     * Обязательный элемент
     * Список/Set
     */
    @OneToMany
    protected Set<MaterialOrItemVerificationInfo> materialOrItemVerificationInfoSet = new HashSet<>();
}
