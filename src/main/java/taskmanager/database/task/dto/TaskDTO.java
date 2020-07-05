package taskmanager.database.task.dto;

import lombok.Data;
import taskmanager.database.section.dto.SectionDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TaskDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private String description;

    @NotNull
    private SectionDTO section;

}
