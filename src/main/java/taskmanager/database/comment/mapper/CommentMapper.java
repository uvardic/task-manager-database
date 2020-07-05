package taskmanager.database.comment.mapper;

import org.mapstruct.Mapper;
import taskmanager.database.comment.domain.Comment;
import taskmanager.database.comment.dto.CommentDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO toDTO(Comment entity);

    Comment toEntity(CommentDTO dto);

    List<CommentDTO> toDTOList(List<Comment> entities);

}
