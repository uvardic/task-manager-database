package taskmanager.database.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskmanager.database.task.domain.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(
            "SELECT task FROM Task task " +
            "JOIN FETCH task.section section " +
            "JOIN FETCH section.project " +
            "WHERE task.section.id = :sectionId " +
            "ORDER BY task.sequence"
    )
    List<Task> findAllBySectionIdOrderBySequence(Long sectionId);

}
