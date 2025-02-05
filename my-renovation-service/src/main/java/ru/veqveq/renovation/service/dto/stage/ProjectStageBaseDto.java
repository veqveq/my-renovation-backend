package ru.veqveq.renovation.service.dto.stage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProjectStageBaseDto {
  private Integer orderNumber;
  private String name;
  private String comment;
}
