package taskmanager.database.project.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import taskmanager.database.common.CycleAvoidingMappingContext;
import taskmanager.database.project.domain.Project;
import taskmanager.database.project.dto.ProjectDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDTO toDTO(Project entity, @Context CycleAvoidingMappingContext context);

    Project toEntity(ProjectDTO dto, @Context CycleAvoidingMappingContext context);

    List<ProjectDTO> toDTOList(List<Project> entities, @Context CycleAvoidingMappingContext context);

}
