package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.AuditedEntity;
import ru.veqveq.renovation.entity.BaseIdEntity;


/**
 * Материал по проекту
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "project_material")
@AttributeOverride(name = "id", column = @Column(name = "project_material_id"))
public class ProjectMaterial extends AuditedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Объем
     */
    @Column(name = "count")
    private Integer count;

    /**
     * Цена за единицу (в центах)
     */
    @Column(name = "price_cents")
    private Long priceCents;

    /**
     * Комментарий
     */
    @Column(name = "comment")
    private String comment;

    /**
     * Признак логического удаления
     */
    @Column(name = "deleted")
    private boolean deleted;

    /**
     * Материал
     */
    @ManyToOne
    @JoinColumn(name = "material_id")
    private DictionaryMaterial material;

    /**
     * Проект ремонта
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    /**
     * Стадия ремонта
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_stage_id")
    private ProjectStage projectStage;

    /**
     * Работа по проекту
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_work_id")
    private ProjectWork projectWork;
}
