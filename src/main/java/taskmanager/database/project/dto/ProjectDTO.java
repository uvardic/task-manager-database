package taskmanager.database.project.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProjectDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

}
