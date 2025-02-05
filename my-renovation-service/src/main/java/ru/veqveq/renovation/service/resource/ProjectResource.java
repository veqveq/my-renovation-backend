package ru.veqveq.renovation.service.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.veqveq.renovation.service.dto.project.impl.ProjectEditDto;
import ru.veqveq.renovation.service.dto.project.impl.ProjectInfoDto;
import ru.veqveq.renovation.service.dto.stage.impl.ProjectStageEditDto;
import ru.veqveq.renovation.service.dto.stage.impl.ProjectStageInfoDto;
import ru.veqveq.renovation.service.mapper.ProjectMapper;
import ru.veqveq.renovation.service.model.Project;
import ru.veqveq.renovation.service.service.ProjectService;

@Tag(name = "Управление проектами ремонта")
@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectResource {
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    @GetMapping
    @Operation(description = "Получить список проектов ремонта c фильтрацией и пагинацией")
    @PageableAsQueryParam
    public Page<ProjectInfoDto> getProjects(@Parameter(hidden = true) Pageable pageable) {
        return projectService.findAll(pageable)
            .map(projectMapper::toDto);
    }

    @GetMapping("/{projectId}")
    @Operation(description = "Получить проект ремонта")
    public ProjectInfoDto getProject(@PathVariable(name = "projectId") Long projectId) {
        Project project = projectService.findById(projectId, true);
        return projectMapper.toDto(project);
    }

    @PostMapping
    @Operation(description = "Создать проект ремонта")
    public ProjectInfoDto createProject(@RequestBody ProjectEditDto dto) {
        Project project = projectService.create(dto);
        return projectMapper.toDto(project);
    }

    @PutMapping("/{projectId}")
    @Operation(description = "Изменить информацию по проекту")
    public ProjectInfoDto updateProject(
        @PathVariable(name = "projectId") Long projectId,
        @RequestBody ProjectEditDto data
    ) {
        Project project = projectService.update(projectId, data);
        return projectMapper.toDto(project);
    }

    @DeleteMapping("/{projectId}")
    @Operation(description = "Удалить проект ремонта")
    public void deleteProject(
        @PathVariable(name = "projectId") Long projectId
    ) {
        projectService.logicDelete(projectId);
    }

    @PatchMapping("/{projectId}/restore")
    @Operation(description = "Восстановить удаленный проект")
    public ProjectInfoDto restoreProject(
        @PathVariable(name = "projectId") Long projectId
    ) {
        Project project = projectService.restoreDeleted(projectId);
        return projectMapper.toDto(project);
    }
}
