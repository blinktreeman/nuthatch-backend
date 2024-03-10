package ru.bcomms.address.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StandardizedAddressResponseDto {
    protected UUID uuid;
    protected String standardizedAddress;
}
