package taskmanager.database.section.mapper;

import org.mapstruct.Mapper;
import taskmanager.database.section.domain.Section;
import taskmanager.database.section.dto.SectionDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    SectionDTO toDTO(Section entity);

    Section toEntity(SectionDTO dto);

    List<SectionDTO> toDTOList(List<Section> entities);

}
