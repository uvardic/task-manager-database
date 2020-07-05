package taskmanager.database.comment.dto;

import lombok.Data;
import taskmanager.database.task.dto.TaskDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    private TaskDTO task;

}
