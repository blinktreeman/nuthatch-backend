package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class MaterialsOrItemsVerificationInfo implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    @Embedded
    private MaterialOrItemVerificationInfoSignedPart signedPart;
}
