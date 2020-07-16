package taskmanager.database.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskmanager.database.comment.domain.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
            "SELECT comment FROM Comment comment " +
            "JOIN FETCH comment.task task " +
            "JOIN FETCH task.section section " +
            "JOIN FETCH section.project " +
            "WHERE comment.task.id = :taskId"
    )
    List<Comment> findAllByTaskId(Long taskId);

}
