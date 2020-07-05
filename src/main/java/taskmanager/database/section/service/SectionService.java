package taskmanager.database.section.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import taskmanager.database.section.domain.Section;
import taskmanager.database.section.dto.SectionDTO;
import taskmanager.database.section.exception.SectionNotFoundException;
import taskmanager.database.section.mapper.SectionMapper;
import taskmanager.database.section.repository.SectionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SectionService {

    private final SectionRepository repository;

    private final SectionMapper mapper;

    @Transactional
    public void deleteById(Long existingId) {
        if (sectionNotFound(existingId))
            throw new SectionNotFoundException(String.format("Section with id: %d, wasn't found!", existingId));

        repository.deleteById(existingId);
    }

    private boolean sectionNotFound(Long existingId) {
        return repository.findById(existingId).isEmpty();
    }

    @Transactional
    public SectionDTO save(SectionDTO request) {
        Section savedEntity = repository.save(mapper.toEntity(request));
        return mapper.toDTO(savedEntity);
    }

    @Transactional
    public SectionDTO update(Long existingId, SectionDTO request) {
        SectionDTO foundSection = findById(existingId);
        foundSection.setName(request.getName());
        foundSection.setProject(request.getProject());

        Section savedEntity = repository.save(mapper.toEntity(foundSection));
        return mapper.toDTO(savedEntity);
    }

    public SectionDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new SectionNotFoundException(
                        String.format("Section with id: %d, wasn't found!", id)
                ));
    }

    public List<SectionDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

}
