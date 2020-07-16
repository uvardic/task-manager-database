package taskmanager.database.comment.domain;

import lombok.Data;
import taskmanager.database.task.domain.Task;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String content;

    @JoinColumn(name="task_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Task task;

}
