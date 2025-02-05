package ru.veqveq.renovation.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasureUnitDto {
  private String value;
  @JsonInclude(NON_NULL)
  private String shortName;
  @JsonInclude(NON_NULL)
  private String fullName;
}
