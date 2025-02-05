package ru.veqveq.renovation.service.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.AuditedEntity;

/**
 * Работа по проекту
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "project_work")
@AttributeOverride(name = "id", column = @Column(name = "project_work_id"))
public class ProjectWork extends AuditedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

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
     * Порядковый номер
     */
    @Column(name = "order_number")
    private Integer orderNumber;

    /**
     * Признак логического удаления
     */
    @Column(name = "deleted")
    private boolean deleted;

    /**
     * Работа
     */
    @ManyToOne
    @JoinColumn(name = "work_id")
    private DictionaryWork work;

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
    @OneToMany(mappedBy = "projectWork", fetch = FetchType.LAZY)
    private List<ProjectMaterial> projectMaterials;

    /**
     * Список стадий работы по проекту
     */
    @OneToMany(mappedBy = "parentProjectWork", fetch = FetchType.LAZY)
    private List<ProjectWork> childProjectWorks;
}
