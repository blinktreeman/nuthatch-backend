package ru.bcomms.organizationandrepresentative.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressResponseDto {
    protected UUID uuid;
    protected String standardizedAddress;
}
