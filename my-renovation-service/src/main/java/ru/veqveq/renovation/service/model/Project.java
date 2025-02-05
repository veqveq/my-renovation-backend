package ru.veqveq.renovation.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import ru.veqveq.renovation.entity.AuditedEntity;

import java.util.List;

/**
 * Проект ремонта
 */
@Entity
@Getter
@Setter
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
@Table(name="project")
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "project_id", nullable = false))
public class Project extends AuditedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    /**
     * Название
     */
    @Column(name = "name")
    private String name;

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
     * Признак логического удаления
     */
    @Column(name = "deleted")
    private boolean deleted;

    /**
     * Список этапов работ
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectStage> stages;

    /**
     * Список работ
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectWork> projectWorks;

    /**
     * Список материалов
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectMaterial> projectMaterials;
}
