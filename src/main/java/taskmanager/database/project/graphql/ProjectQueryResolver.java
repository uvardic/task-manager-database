package taskmanager.database.project.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.project.dto.ProjectDTO;
import taskmanager.database.project.service.ProjectService;

import java.util.List;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ProjectQueryResolver implements GraphQLQueryResolver {

    private final ProjectService service;

    public ProjectDTO findProjectById(Long id) {
        return service.findById(id);
    }

    public List<ProjectDTO> findAllProjects() {
        return service.findAll();
    }

}
