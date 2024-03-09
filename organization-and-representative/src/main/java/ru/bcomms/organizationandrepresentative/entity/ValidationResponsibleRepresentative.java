package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Описание комплексного типа: ValidationResponsibleRepresentativeSignedPart,
 * Подписываемая часть информации о представителе, ответственном за верификацию
 */
@Data
@Entity
public class ValidationResponsibleRepresentative implements Serializable {
    /**
     * Id подписываемой части информации о представителе, ответственном за верификацию.
     * Обязательный элемент
     * Строгий формат:
     * _хххххххх-хххх-хххх-хххх-хххххххххххх
     * Наложенные ограничения
     * _[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}
     */
    @Id
    @GeneratedValue
    protected UUID uuid;
    /**
     * Информация о представителе (ФИО, должность, ID сотрудника).
     * Обязательный элемент
     */
    @ManyToOne(fetch = FetchType.EAGER)
    protected Representative representative;
    /**
     * Распорядительный документ, подтверждающий полномочия.
     * Обязательный элемент
     * document-service CustomDocument
     */
    @ElementCollection
    protected List<UUID> administrativeDocument;

}
