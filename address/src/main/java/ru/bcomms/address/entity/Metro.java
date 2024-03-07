package ru.bcomms.address.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "metro_name")),
        @AttributeOverride(name = "line", column = @Column(name = "metro_line")),
        @AttributeOverride(name = "name", column = @Column(name = "metro_distance"))
})
public class Metro {
    String name;
    String line;
    Double distance;
}
