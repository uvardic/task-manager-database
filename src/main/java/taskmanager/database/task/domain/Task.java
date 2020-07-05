package taskmanager.database.task.domain;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import taskmanager.database.section.domain.Section;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Section section;

}
