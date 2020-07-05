package taskmanager.database.project.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.project.dto.ProjectDTO;
import taskmanager.database.project.service.ProjectService;

import javax.validation.Valid;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ProjectMutationResolver implements GraphQLMutationResolver {

    private final ProjectService service;

    public Long deleteProjectById(Long existingId) {
        service.deleteById(existingId);
        return existingId;
    }

    public ProjectDTO saveProject(@Valid ProjectDTO request) {
        return service.save(request);
    }

    public ProjectDTO updateProject(Long existingId, @Valid ProjectDTO request) {
        return service.update(existingId, request);
    }

}
