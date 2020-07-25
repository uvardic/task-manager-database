package taskmanager.database.task.dto;

import lombok.Data;
import taskmanager.database.comment.dto.CommentDTO;
import taskmanager.database.section.dto.SectionDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Data
public class TaskDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private String description;

    @NotNull
    @Positive
    private Double sequence;

    @NotNull
    private SectionDTO section;

    private List<@NotNull CommentDTO> comments = new ArrayList<>();

}
