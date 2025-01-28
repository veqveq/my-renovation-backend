package ru.veqveq.renovation.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseNamedEntity<T extends Number> extends BaseIdEntity<T> {
    @Column(name = "name")
    private String name;
}
