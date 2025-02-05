package ru.veqveq.renovation.service.dto.stage.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.material.impl.project.ProjectMaterialInfoDto;
import ru.veqveq.renovation.service.dto.stage.ProjectStageBaseDto;
import ru.veqveq.renovation.service.dto.work.impl.project.ProjectWorkInfoDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectStageInfoDto extends ProjectStageBaseDto {
  private Long id;

  private List<ProjectWorkInfoDto> works;
  private List<ProjectMaterialInfoDto> materials;
}
