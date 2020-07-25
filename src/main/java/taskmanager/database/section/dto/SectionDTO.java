package taskmanager.database.section.dto;

import lombok.Data;
import taskmanager.database.project.dto.ProjectDTO;
import taskmanager.database.task.dto.TaskDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Data
public class SectionDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Double sequence;

    @NotNull
    private ProjectDTO project;

    private List<@NotNull TaskDTO> tasks = new ArrayList<>();

}
