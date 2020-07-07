package taskmanager.database.section.dto;

import lombok.Data;
import taskmanager.database.project.dto.ProjectDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class SectionDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private Integer indexInProject;

    @NotNull
    private ProjectDTO project;

}
