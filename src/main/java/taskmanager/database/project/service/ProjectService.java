package taskmanager.database.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import taskmanager.database.common.CycleAvoidingMappingContext;
import taskmanager.database.project.domain.Project;
import taskmanager.database.project.dto.ProjectDTO;
import taskmanager.database.project.exception.ProjectNotFoundException;
import taskmanager.database.project.mapper.ProjectMapper;
import taskmanager.database.project.repository.ProjectRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;

    private final ProjectMapper mapper;

    private final CycleAvoidingMappingContext mappingContext;

    @Transactional
    public void deleteById(Long existingId) {
        if (projectNotFound(existingId))
            throw new ProjectNotFoundException(String.format("Project with id: %d wasn't found!", existingId));

        repository.deleteById(existingId);
    }

    private boolean projectNotFound(Long id) {
        return repository.findById(id).isEmpty();
    }

    @Transactional
    public ProjectDTO save(ProjectDTO request) {
        Project savedEntity = repository.save(mapper.toEntity(request, mappingContext));
        return mapper.toDTO(savedEntity, mappingContext);
    }

    @Transactional
    public ProjectDTO update(Long existingId, ProjectDTO request) {
        ProjectDTO foundProject = findById(existingId);
        foundProject.setName(request.getName());
        foundProject.setSections(request.getSections());

        Project savedEntity = repository.save(mapper.toEntity(foundProject, mappingContext));
        return mapper.toDTO(savedEntity, mappingContext);
    }

    public ProjectDTO findById(Long id) {
        return repository.findById(id)
                .map(project -> mapper.toDTO(project, mappingContext))
                .orElseThrow(() -> new ProjectNotFoundException(
                        String.format("Project with id: %d, wasn't found!", id)
                ));
    }

    public List<ProjectDTO> findAll() {
        return mapper.toDTOList(repository.findAll(), mappingContext);
    }

}
