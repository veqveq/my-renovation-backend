package ru.veqveq.renovation.service.dto.project.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.project.ProjectBaseDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectEditDto extends ProjectBaseDto {
}
