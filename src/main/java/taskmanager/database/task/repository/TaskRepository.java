package taskmanager.database.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanager.database.task.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
