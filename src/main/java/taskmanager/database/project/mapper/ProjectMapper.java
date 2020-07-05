package taskmanager.database.project.mapper;

import org.mapstruct.Mapper;
import taskmanager.database.project.domain.Project;
import taskmanager.database.project.dto.ProjectDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDTO toDTO(Project entity);

    Project toEntity(ProjectDTO dto);

    List<ProjectDTO> toDTOList(List<Project> entities);

}
