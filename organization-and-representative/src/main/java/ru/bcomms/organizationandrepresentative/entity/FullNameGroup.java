package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Описание комплексного типа: FullNameGroup.
 * Группа, содержащая Фамилию, Имя, Отчество
 */
@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "lastName", column = @Column(name = "full_name_group_last_name")),
        @AttributeOverride(name = "firstName", column = @Column(name = "full_name_group_first_name")),
        @AttributeOverride(name = "middleName", column = @Column(name = "full-mae_group_middle_name"))
})
public class FullNameGroup {
    /**
     * Фамилия. Обязательный элемент
     */
    @NotNull
    @Size(min = 1, message = "Фамилия. Обязательный элемент")
    @Column(nullable = false)
    private String lastName;
    /**
     * Имя. Обязательный элемент
     */
    @NotNull
    @Size(min = 1, message = "Имя. Обязательный элемент")
    @Column(nullable = false)
    private String firstName;
    /**
     * Отчество. Обязательный элемент
     */
    @NotNull
    @Size(min = 1, message = "Отчество. Обязательный элемент")
    @Column(nullable = false)
    private String middleName;
}
