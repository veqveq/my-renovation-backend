package ru.veqveq.renovation.service.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.veqveq.renovation.service.dto.project.impl.ProjectInfoDto;
import ru.veqveq.renovation.service.dto.stage.impl.ProjectStageEditDto;
import ru.veqveq.renovation.service.dto.stage.impl.ProjectStageInfoDto;

@Tag(name = "Управление стадиями проекта")
@RestController
@RequiredArgsConstructor
@RequestMapping("/project/{projectId}/stage")
public class ProjectStageResource {
  @GetMapping
  @Operation(description = "Получить список стадий работ по проекту")
  @PageableAsQueryParam
  public Page<ProjectStageInfoDto> getProjectStages(
      @PathVariable(name = "projectId") Long projectId,
      @Parameter(hidden = true) Pageable pageable
  ) {
    return null;
  }

  @GetMapping("/{stageId}")
  @Operation(description = "Получить стадию работ")
  public ProjectStageInfoDto getProjectStage(
      @PathVariable(name = "projectId") Long projectId,
      @PathVariable(name = "stageId") Long stageId
  ) {
    return null;
  }

  @PostMapping
  @Operation(description = "Создать стадию работ по проекту")
  public ProjectStageInfoDto createProjectStage(
      @PathVariable(name = "projectId") Long projectId,
      @RequestBody ProjectStageEditDto data
  ) {
    return null;
  }

  @PutMapping("/{stageId}")
  @Operation(description = "Изменить стадию работ по проекту")
  public ProjectStageInfoDto updateProjectStage(
      @PathVariable(name = "projectId") Long projectId,
      @PathVariable(name = "stageId") Long stageId,
      @RequestBody ProjectStageEditDto data
  ) {
    return null;
  }

  @DeleteMapping("/{stageId}")
  @Operation(description = "Удалить стадию работ по проекту")
  public ProjectInfoDto deleteProjectStage(
      @PathVariable(name = "projectId") Long projectId,
      @PathVariable(name = "stageId") Long stageId
  ) {
    return null;
  }
}
