package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class IncomingMaterialsControlInfo implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    @Embedded
    private BaseDocument baseDocument;
    private UUID permanentObjectId;
    @OneToMany
    private Set<MaterialsOrItemsVerificationInfo> materialsOrItemsVerificationInfos = new HashSet<>();
}
