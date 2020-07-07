package taskmanager.database.section.domain;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import taskmanager.database.project.domain.Project;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer indexInProject;

    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Project project;

}
