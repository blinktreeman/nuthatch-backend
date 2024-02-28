package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Описание комплексного типа: IncomingMaterialsControlInfo.
 * Сведения о входном контроле материалов и изделий
 */
@Data
@Entity
public class IncomingMaterialsControlInfo implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Информация об UUID и редакции документа, UUID объекта капитального
     * строительства, версии схемы.
     * Обязательный элемент
     */
    @Embedded
    private BaseDocument baseDocument;
    /**
     * id объекта капитального строительства.
     * Обязательный элемент
     * Строгий формат:
     * хххххххх-хххх-хххх-хххх-хххххххххххх
     * Наложенные ограничения
     * [0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    private UUID permanentObjectId;
    /**
     * Сведения о верификации материалов/изделий (список).
     * Обязательный элемент
     */
    @OneToMany
    private Set<MaterialsOrItemsVerificationInfo> materialsOrItemsVerificationInfos = new HashSet<>();
}
