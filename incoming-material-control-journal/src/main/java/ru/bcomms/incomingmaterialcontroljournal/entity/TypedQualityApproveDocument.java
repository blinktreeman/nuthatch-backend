package ru.bcomms.incomingmaterialcontroljournal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Описание комплексного типа: TypedQualityApproveDocument.
 * Комплект типизированных ДПК
 */
@Data
@Entity
public class TypedQualityApproveDocument implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    @ManyToMany
    private Set<DocRequisites> materialAmountQualityDocument = new HashSet<>();
    @ManyToMany
    private Set<DocRequisites> parametersComplianceDocument = new HashSet<>();
    @ManyToMany
    private Set<DocRequisites> additionalParametersComplianceDocument = new HashSet<>();
    @ManyToMany
    private Set<DocRequisites> additionalQualityDocument = new HashSet<>();
}
