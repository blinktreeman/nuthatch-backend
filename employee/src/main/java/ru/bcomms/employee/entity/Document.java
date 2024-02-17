package ru.bcomms.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Document implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String title;
    private String description;

    public Document(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
