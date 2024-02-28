package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Описание комплексного типа: ValidationResponsibleRepresentativesListItem.
 * Представитель строительной организации,
 * ответственный за верификацию
 */
@Data
@Entity
public class ValidationResponsibleRepresentativesListItem implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Подписываемая часть информации о представителе, ответственном за верификацию.
     * Обязательный элемент
     */
    @OneToOne
    private ValidationResponsibleRepresentativeSignedPart validationResponsibleRepresentativeSignedPart;
}
