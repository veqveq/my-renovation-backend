package ru.veqveq.renovation.service.mapper;

import org.mapstruct.Mapper;
import ru.veqveq.renovation.service.dto.ProjectDto;
import ru.veqveq.renovation.service.model.Project;

@Mapper
public interface ProjectMapper {
    ProjectDto toDto(Project source);
}
