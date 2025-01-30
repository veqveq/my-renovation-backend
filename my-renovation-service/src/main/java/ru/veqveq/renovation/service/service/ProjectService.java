package ru.veqveq.renovation.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.veqveq.renovation.service.dao.ProjectDao;
import ru.veqveq.renovation.service.dto.ProjectDto;
import ru.veqveq.renovation.service.mapper.ProjectMapper;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectDao projectDao;
    private final ProjectMapper projectMapper;

    public Page<ProjectDto> findAll(Pageable pageable) {
        return projectDao.findAll(pageable).map(projectMapper::toDto);
    }
}
