package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class MaterialsOrItemsVerificationInfo implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    @OneToOne
    private MaterialOrItemVerificationInfoSignedPart signedPart;
    // TODO: Signature в common сервис
//    private Signature signature;
}
