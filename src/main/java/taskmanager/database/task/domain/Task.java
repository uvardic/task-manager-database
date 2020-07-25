package taskmanager.database.task.domain;

import lombok.Data;
import taskmanager.database.comment.domain.Comment;
import taskmanager.database.section.domain.Section;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double sequence;

    @JoinColumn(name = "section_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Section section;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

}
