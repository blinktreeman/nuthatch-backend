package ru.bcomms.buildingproject.dto;

import jakarta.persistence.Embedded;
import lombok.Data;
import ru.bcomms.buildingproject.entity.Person;

import java.util.UUID;

@Data
public class ProjectInfoDto {
    protected UUID uuid;
    /**
     * Ссылка на объект строительства
     */
    protected UUID buildingObject;
    /**
     * Наименование раздела проекта
     */
    protected String title;
    /**
     * Шифр проекта
     */
    protected String code;
    /**
     * Главный инженер проекта
     */
    @Embedded
    protected Person chiefEngineer;
}
