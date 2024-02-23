package ru.bcomms.organizationandrepresentative.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Signature implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;

    // TODO: Signing
}
