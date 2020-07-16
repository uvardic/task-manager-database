package taskmanager.database.project.dto;

import lombok.Data;
import taskmanager.database.section.dto.SectionDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private List<@NotNull SectionDTO> sections = new ArrayList<>();

}
