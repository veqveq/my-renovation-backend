package ru.veqveq.renovation.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.veqveq.renovation.service.model.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {
}
