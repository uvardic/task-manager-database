package taskmanager.database.task.dto;

import lombok.Data;
import taskmanager.database.section.dto.SectionDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class TaskDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private String description;

    @NotNull
    @PositiveOrZero
    private Integer indexInSection;

    @NotNull
    private SectionDTO section;

}
