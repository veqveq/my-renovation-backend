package ru.veqveq.renovation.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.veqveq.renovation.service.dto.project.impl.ProjectEditDto;
import ru.veqveq.renovation.service.dto.project.impl.ProjectInfoDto;
import ru.veqveq.renovation.service.model.Project;

@Mapper
public interface ProjectMapper {
    ProjectInfoDto toDto(Project source);

    Project toEntity(ProjectEditDto dto);

    void merge(@MappingTarget Project target, ProjectEditDto source);
}
