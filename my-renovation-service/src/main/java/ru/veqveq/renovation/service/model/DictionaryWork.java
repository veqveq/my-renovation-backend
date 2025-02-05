package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.AuditedEntity;
import ru.veqveq.renovation.model.MeasureUnit;

import java.util.List;

/**
 * Описание строительной работы
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "work")
@AttributeOverride(name = "id", column = @Column(name = "work_id"))
public class DictionaryWork extends AuditedEntity<Long> {
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
     * Родительская работа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_work_id")
    private DictionaryWork parentWork;

    /**
     * Список материалов для работы
     */
    @OneToMany(mappedBy = "work")
    private List<DictionaryMaterial> materials;

    /**
     * Список стадий работы
     */
    @OneToMany(mappedBy = "parentWork")
    private List<DictionaryWork> childWorks;
}
