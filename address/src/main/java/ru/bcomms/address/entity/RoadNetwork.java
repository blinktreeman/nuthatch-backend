package ru.bcomms.address.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Описание комплексного типа: RoadNetwork
 * Наименование элемента улично-дорожной сети
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "road_network_element",
                column = @Column(name = "road_network_road_network_element")),
        @AttributeOverride(name = "road_network_object",
                column = @Column(name = "road_network_road_network_object"))
})
public class RoadNetwork {
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
