package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.BaseNamedEntity;

import java.util.List;

/**
 * Этап работ
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "project_stage")
@AttributeOverride(name = "id", column = @Column(name = "project_stage_id"))
public class ProjectStage extends BaseNamedEntity<Long> {
    /**
     * Комментарий
     */
    @Column(name = "comment")
    private String comment;

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
    private List<ProjectWork> projectWorkList;
    /**
     * Список работ
     */
    @OneToMany(mappedBy = "projectStage")
    private List<ProjectMaterial> projectMaterialList;
}
