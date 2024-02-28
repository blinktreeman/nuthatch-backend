package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Организация и её представители
 */
@Data
@Entity
public class OrganisationAndRepresentative implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;

    // Id организации TODO: Org Relation !!!!!
    private UUID organizationId;

    /**
     * Список представителей строительной
     * организации, ответственных за верификацию
     */
    @OneToMany
    private Set<ValidationResponsibleRepresentativesListItem> validationResponsibleRepresentatives
            = new HashSet<>();
}
