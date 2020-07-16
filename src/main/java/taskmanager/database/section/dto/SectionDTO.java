package taskmanager.database.section.dto;

import lombok.Data;
import taskmanager.database.project.dto.ProjectDTO;
import taskmanager.database.task.dto.TaskDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

@Data
public class SectionDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private Integer sequence;

    @NotNull
    private ProjectDTO project;

    private List<@NotNull TaskDTO> tasks = new ArrayList<>();

}
