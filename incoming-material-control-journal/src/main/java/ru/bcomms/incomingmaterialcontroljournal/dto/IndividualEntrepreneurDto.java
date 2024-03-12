package ru.bcomms.incomingmaterialcontroljournal.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class IndividualEntrepreneurDto {
    protected UUID uuid;
    protected FullNameGroup fullNameGroup;
    protected String address;
    protected String ogrnip;
    protected String inn;
}
