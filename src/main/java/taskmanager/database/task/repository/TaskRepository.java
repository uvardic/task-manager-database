package taskmanager.database.task.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskmanager.database.task.domain.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @NotNull
    @Query(
            "SELECT task FROM Task task " +
            "JOIN FETCH task.section section " +
            "JOIN FETCH section.project " +
            "WHERE task.id = :id"
    )
    Optional<Task> findById(@NotNull Long id);

    @Query(
            "SELECT task FROM Task task " +
            "JOIN FETCH task.section section " +
            "JOIN FETCH section.project " +
            "WHERE task.section.id = :sectionId " +
            "ORDER BY task.sequence"
    )
    List<Task> findAllBySectionIdOrderBySequence(Long sectionId);

}
