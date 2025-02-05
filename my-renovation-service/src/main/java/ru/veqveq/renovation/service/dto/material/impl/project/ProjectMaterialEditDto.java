package ru.veqveq.renovation.service.dto.material.impl.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.material.MaterialBaseDto;
import ru.veqveq.renovation.service.dto.material.impl.dictionary.DictionaryMaterialEditDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectMaterialEditDto extends MaterialBaseDto {
  private DictionaryMaterialEditDto materialInfo;
  private Integer orderNumber;
  private Integer count;
  private Long priceCents;
  private Long costCents;
  private String comment;
}
