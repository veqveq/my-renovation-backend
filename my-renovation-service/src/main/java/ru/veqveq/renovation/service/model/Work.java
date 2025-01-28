package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.BaseNamedEntity;
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
public class Work extends BaseNamedEntity<Long> {
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
    private Work parentWork;

    /**
     * Список материалов для работы
     */
    @OneToMany(mappedBy = "work")
    private List<Material> materialList;
}
