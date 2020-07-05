package taskmanager.database.section.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.section.dto.SectionDTO;
import taskmanager.database.section.service.SectionService;

import javax.validation.Valid;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class SectionMutationResolver implements GraphQLMutationResolver {

    private final SectionService service;

    public Long deleteSectionById(Long existingId) {
        service.deleteById(existingId);
        return existingId;
    }

    public SectionDTO saveSection(@Valid SectionDTO request) {
        return service.save(request);
    }

    public SectionDTO updateSection(Long existingId, @Valid SectionDTO request) {
        return service.update(existingId, request);
    }

}
