package ru.veqveq.renovation.service.dto.project.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import ru.veqveq.renovation.service.dto.material.impl.project.ProjectMaterialInfoDto;
import ru.veqveq.renovation.service.dto.project.ProjectBaseDto;
import ru.veqveq.renovation.service.dto.stage.impl.ProjectStageInfoDto;
import ru.veqveq.renovation.service.dto.work.impl.project.ProjectWorkInfoDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectInfoDto extends ProjectBaseDto {
    private Long id;
    private List<ProjectStageInfoDto> projectStages;
    private List<ProjectWorkInfoDto> projectWorks;
    private List<ProjectMaterialInfoDto> projectMaterials;
}
