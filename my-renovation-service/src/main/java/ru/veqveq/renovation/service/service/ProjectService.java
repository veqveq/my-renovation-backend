package ru.veqveq.renovation.service.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.veqveq.renovation.entity.AuditedEntity;
import ru.veqveq.renovation.service.dao.ProjectDao;
import ru.veqveq.renovation.service.dto.project.impl.ProjectEditDto;
import ru.veqveq.renovation.service.exception.EntityNotFoundException;
import ru.veqveq.renovation.service.mapper.ProjectMapper;
import ru.veqveq.renovation.service.model.Project;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectDao projectDao;
    private final ProjectMapper projectMapper;

    public Page<Project> findAll(Pageable pageable) {
        return projectDao.findAllByDeletedIsFalse(getPageParams(pageable));
    }

    public Project findById(Long projectId, boolean onlyActive) {
        Optional<Project> project = onlyActive
            ? projectDao.findActiveById(projectId)
            : projectDao.findById(projectId);
        return project.orElseThrow(EntityNotFoundException::new);
    }

    public Project create(ProjectEditDto dto) {
        return projectDao.save(projectMapper.toEntity(dto));
    }

    public Project update(Long projectId, ProjectEditDto dto) {
        Project project = findById(projectId, true);
        projectMapper.merge(project, dto);
        return projectDao.save(project);
    }

    public void logicDelete(Long projectId) {
        Project project = findById(projectId, true);
        project.setDeleted(true);
        projectDao.save(project);
    }

    public Project restoreDeleted(Long projectId) {
        Project project = findById(projectId, false);
        project.setDeleted(false);
        return projectDao.save(project);
    }

    private Pageable getPageParams(Pageable pageable) {
        if (pageable.getSort().isEmpty()) {
            Sort defaultSort = Sort.by(AuditedEntity.Fields.createdAt).descending();
            return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), defaultSort);
        }
        return pageable;
    }
}
