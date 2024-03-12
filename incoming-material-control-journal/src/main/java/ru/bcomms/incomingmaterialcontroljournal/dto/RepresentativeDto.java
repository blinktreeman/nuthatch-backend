package ru.bcomms.incomingmaterialcontroljournal.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RepresentativeDto {
    protected UUID uuid;
    protected FullNameGroup fullNameGroup;
    protected String nostroyNumber;
}
