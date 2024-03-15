package ru.bcomms.incomingmaterialcontroljournal.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * Описание комплексного типа: IncomingMaterialControlJournal.
 * Журнал входного контроля
 */
@Data
@Entity
@Table(name = "incoming_material_control_journal")
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
    @OneToMany(mappedBy = "incomingMaterialControlJournal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<MaterialOrItemVerificationInfo> materialOrItemVerificationInfoList = new ArrayList<>();
}
