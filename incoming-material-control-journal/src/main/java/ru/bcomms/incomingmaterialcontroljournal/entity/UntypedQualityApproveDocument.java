package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class UntypedQualityApproveDocument {
    @Id
    @GeneratedValue
    private UUID uuid;
    /*
     TODO: untypedQualityApproveDocument = docRequisitesWithOptionalSignaturesFiles (DocRequisites)
     Вынести common элементы в отдельный сервис
     */
}
