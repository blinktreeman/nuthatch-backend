package ru.bcomms.address.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Описание комплексного типа: Room
 * Тип и номер помещения
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "room_type", column = @Column(name = "room_room_type")),
        @AttributeOverride(name = "room_number", column = @Column(name = "room_room_number"))
})
public class Room {
    /**
     * Тип помещения
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String roomType;
    /**
     * Номер помещения
     * Обязательный элемент
     * Минимум 1 символ
     */
    @Column(nullable = false)
    private String roomNumber;

}
