package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.veqveq.renovation.entity.BaseNamedEntity;

import java.util.List;

/**
 * Проект ремонта
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="project")
@AttributeOverride(name = "id", column = @Column(name = "project_id"))
public class Project extends BaseNamedEntity<Long> {
    /**
     * Адрес объекта
     */
    @Column(name = "address")
    private String address;

    /**
     * Комментарий
     */
    @Column(name = "description")
    private String description;

    /**
     * Список этапов работ
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectStage> stageList;

    /**
     * Список работ
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectWork> projectWorkList;

    /**
     * Список материалов
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectMaterial> projectMaterialList;
}
