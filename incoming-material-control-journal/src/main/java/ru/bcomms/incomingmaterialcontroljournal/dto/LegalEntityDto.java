package ru.bcomms.incomingmaterialcontroljournal.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LegalEntityDto {
    protected UUID uuid;
    protected String shortName;
    protected String ogrn;
    protected String inn;
    protected String address;
}
