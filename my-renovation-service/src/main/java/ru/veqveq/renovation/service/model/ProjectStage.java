package ru.veqveq.renovation.service.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
 * Этап работ
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "project_stage")
@AttributeOverride(name = "id", column = @Column(name = "project_stage_id"))
public class ProjectStage extends AuditedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Название
     */
    @Column(name = "name")
    private String name;

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
     * Проект ремонта
     */
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    /**
     * Список работ
     */
    @OneToMany(mappedBy = "projectStage")
    private List<ProjectWork> projectWorks;

    /**
     * Список работ
     */
    @OneToMany(mappedBy = "projectStage")
    private List<ProjectMaterial> projectMaterials;
}
