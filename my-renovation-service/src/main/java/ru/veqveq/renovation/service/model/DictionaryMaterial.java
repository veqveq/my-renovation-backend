package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.AuditedEntity;
import ru.veqveq.renovation.model.MeasureUnit;

/**
 * Описание строительного материала
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "material")
@AttributeOverride(name = "id", column = @Column(name = "material_id"))
public class DictionaryMaterial extends AuditedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Название
     */
    @Column(name = "name")
    private String name;

    /**
     * Единица измерения
     */
    @Column(name = "unit")
    @Enumerated(value = EnumType.STRING)
    private MeasureUnit unit;

    /**
     * Работа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    private DictionaryWork work;
}