package ru.veqveq.renovation.service.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.veqveq.renovation.service.dto.material.impl.project.ProjectMaterialInfoDto;

@Tag(name = "Управление материалами в проекте")
@RestController
@RequiredArgsConstructor
@RequestMapping("/project/material")
public class ProjectMaterialResource {
  @GetMapping
  @Operation(description = "Получить список материалов по идентификатору проекта")
  @PageableAsQueryParam
  public Page<ProjectMaterialInfoDto> getProjectMaterials(
      @Parameter(name = "projectId") Long projectId,
      @Parameter(hidden = true) Pageable pageable
  ) {
    return null;
  }
}
