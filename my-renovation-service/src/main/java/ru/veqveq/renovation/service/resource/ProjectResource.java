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
import ru.veqveq.renovation.service.dto.ProjectDto;
import ru.veqveq.renovation.service.service.ProjectService;

@Tag(name = "Контроллер значений справочников")
@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectResource {
    private final ProjectService projectService;
    @GetMapping
    @Operation(description = "Получить список проектов")
    @PageableAsQueryParam
    public Page<ProjectDto> getProjects(@Parameter(hidden = true) Pageable pageable) {
        return projectService.findAll(pageable);
    }
}
