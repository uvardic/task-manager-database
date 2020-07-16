package taskmanager.database.section.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskmanager.database.section.domain.Section;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @NotNull
    @Query(
            "SELECT section FROM Section section " +
            "JOIN FETCH section.project"
    )
    List<Section> findAll();

    @Query(
            "SELECT section FROM Section section " +
            "JOIN FETCH section.project " +
            "WHERE section.project.id = :projectId " +
            "ORDER BY section.sequence"
    )
    List<Section> findAllByProjectIdOrderBySequence(Long projectId);

}