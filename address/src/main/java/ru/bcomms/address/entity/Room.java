package ru.bcomms.address.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Описание комплексного типа: Room
 * Тип и номер помещения
 */
@Data
@NoArgsConstructor
@Entity
public class Room implements AbstractEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
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

    public Room(String roomType, String roomNumber) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }
}
