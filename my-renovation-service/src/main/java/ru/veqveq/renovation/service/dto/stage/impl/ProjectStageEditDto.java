package ru.veqveq.renovation.service.dto.stage.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.stage.ProjectStageBaseDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectStageEditDto extends ProjectStageBaseDto {
}
