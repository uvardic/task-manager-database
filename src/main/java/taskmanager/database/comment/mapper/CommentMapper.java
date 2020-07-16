package taskmanager.database.comment.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import taskmanager.database.comment.domain.Comment;
import taskmanager.database.comment.dto.CommentDTO;
import taskmanager.database.common.CycleAvoidingMappingContext;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO toDTO(Comment entity, @Context CycleAvoidingMappingContext context);

    Comment toEntity(CommentDTO dto, @Context CycleAvoidingMappingContext context);

    List<CommentDTO> toDTOList(List<Comment> entities, @Context CycleAvoidingMappingContext context);

}
