package ru.bcomms.incomingmaterialcontroljournal.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "journal")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uuid"
)
public class IncomingMaterialControlJournal implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;
    /**
     * Титульный лист. Обязательный элемент
     */
    @Embedded
    @Column(name = "journal_title")
    protected IncomingMaterialControlJournalTitle incomingMaterialControlJournalTitle;
    /**
     * Верификация закупленной продукции (список результатов процедур входного контроля материалов).
     * Обязательный элемент
     * Список/Set
     */
    @OneToMany(mappedBy = "incomingMaterialControlJournal", cascade = CascadeType.ALL)
    protected Set<MaterialOrItemVerificationInfo> materialOrItemVerificationInfoSet = new HashSet<>();
}
