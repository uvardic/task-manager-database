package taskmanager.database.task.mapper;

import org.mapstruct.Mapper;
import taskmanager.database.task.domain.Task;
import taskmanager.database.task.dto.TaskDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDTO(Task entity);

    Task toEntity(TaskDTO dto);

    List<TaskDTO> toDTOList(List<Task> entities);

}
