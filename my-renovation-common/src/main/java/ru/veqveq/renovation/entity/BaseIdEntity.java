package ru.veqveq.renovation.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseIdEntity<T extends Number> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected T id;
}
