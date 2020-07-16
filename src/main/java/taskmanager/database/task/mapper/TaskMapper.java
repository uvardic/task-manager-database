package taskmanager.database.task.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import taskmanager.database.common.CycleAvoidingMappingContext;
import taskmanager.database.task.domain.Task;
import taskmanager.database.task.dto.TaskDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDTO(Task entity, @Context CycleAvoidingMappingContext context);

    Task toEntity(TaskDTO dto, @Context CycleAvoidingMappingContext context);

    List<TaskDTO> toDTOList(List<Task> entities, @Context CycleAvoidingMappingContext context);

}
