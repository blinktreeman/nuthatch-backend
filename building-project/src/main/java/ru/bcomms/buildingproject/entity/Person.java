package ru.bcomms.buildingproject.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "first_name", column = @Column(name = "person_first_name")),
        @AttributeOverride(name = "last_name", column = @Column(name = "person_last_name")),
        @AttributeOverride(name = "patronymic", column = @Column(name = "person_patronymic")),
        @AttributeOverride(name = "phone", column = @Column(name = "person_phone"))
})
public class Person {
    protected String firstName;
    protected String lastName;
    protected String patronymic;
    protected String phone;
}
