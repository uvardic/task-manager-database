package taskmanager.database.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanager.database.project.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
