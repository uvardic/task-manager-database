package taskmanager.database.section.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.section.dto.SectionDTO;
import taskmanager.database.section.service.SectionService;

import java.util.List;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class SectionQueryResolver implements GraphQLQueryResolver {

    private final SectionService service;

    public SectionDTO findSectionById(Long id) {
        return service.findById(id);
    }

    public List<SectionDTO> findAllSectionsByProjectIdOrderByIndexInProject(Long projectId) {
        return service.findAllByProjectIdOrderByIndexInProject(projectId);
    }

    public List<SectionDTO> findAllSections() {
        return service.findAll();
    }

}
