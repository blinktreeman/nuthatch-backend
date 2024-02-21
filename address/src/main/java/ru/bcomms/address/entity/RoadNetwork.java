package ru.bcomms.address.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Описание комплексного типа: RoadNetwork
 * Наименование элемента улично-дорожной сети
 */
@Data
@Entity
@Table(name = "road_network")
public class RoadNetwork implements AbstractEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Наименование элемента улично-дорожной сети
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String roadNetworkElement;
    /**
     * Наименование объекта улично-дорожной сети
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String roadNetworkObject;
}
