package ru.bcomms.buildingproject.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class CommonEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
}
