package ru.veqveq.renovation.service.dto.work.impl.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.material.impl.project.ProjectMaterialInfoDto;
import ru.veqveq.renovation.service.dto.work.WorkBaseDto;
import ru.veqveq.renovation.service.dto.work.impl.dictionary.DictionaryWorkEditDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectWorkEditDto extends WorkBaseDto {
  private DictionaryWorkEditDto workInfo;
  private Integer orderNumber;
  private Integer count;
  private Long priceCents;
  private Long costCents;
  private String comment;
  private List<ProjectWorkInfoDto> childProjectWorks;
  private List<ProjectMaterialInfoDto> projectMaterials;
}
