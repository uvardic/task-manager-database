package taskmanager.database.section.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import taskmanager.database.common.CycleAvoidingMappingContext;
import taskmanager.database.section.domain.Section;
import taskmanager.database.section.dto.SectionDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    SectionDTO toDTO(Section entity, @Context CycleAvoidingMappingContext context);

    Section toEntity(SectionDTO dto, @Context CycleAvoidingMappingContext context);

    List<SectionDTO> toDTOList(List<Section> entities, @Context CycleAvoidingMappingContext context);

}
