package ru.veqveq.renovation.service.dto.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProjectBaseDto {
  private String name;
  private String address;
  private String description;
}
