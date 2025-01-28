package ru.veqveq.renovation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseIdEntity<T extends Number> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected T id;
}
