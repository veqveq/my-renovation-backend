package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.BaseIdEntity;

import java.util.List;

/**
 * Работа по проекту
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "project_work")
@AttributeOverride(name = "id", column = @Column(name = "project_work_id"))
public class ProjectWork extends BaseIdEntity<Long> {
    /**
     * Объем работы
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
     * Работа
     */
    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

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
     * Родительская работа по проекту
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_project_work_id")
    private ProjectWork parentProjectWork;

    /**
     * Список цен на материалы для работы
     */
    @OneToMany(mappedBy = "projectWork")
    private List<ProjectMaterial> projectMaterialList;
}
