package ru.veqveq.renovation.service.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.veqveq.renovation.service.model.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {
  @Query(
    """
      select p
      from Project p
      where p.deleted = false
        and p.id = :projectId
    """
  )
  Optional<Project> findActiveById(@Param("projectId") Long projectId);

  Page<Project> findAllByDeletedIsFalse(Pageable pageable);
}
