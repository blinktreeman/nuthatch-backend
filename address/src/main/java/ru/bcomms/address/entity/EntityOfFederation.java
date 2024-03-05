package ru.bcomms.address.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class EntityOfFederation implements AbstractEntity {
    @Id
    @GeneratedValue
    protected UUID uuid;
    protected String name;
}
