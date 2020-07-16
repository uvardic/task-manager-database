package taskmanager.database.comment.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.comment.dto.CommentDTO;
import taskmanager.database.comment.service.CommentService;

import java.util.List;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CommentQueryResolver implements GraphQLQueryResolver {

    private final CommentService service;

    public CommentDTO findCommentById(Long id) {
        return service.findById(id);
    }

    public List<CommentDTO> findAllCommentsByTaskId(Long taskId) {
        return service.findAllByTaskId(taskId);
    }
}
