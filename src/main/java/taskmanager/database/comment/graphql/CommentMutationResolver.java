package taskmanager.database.comment.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.comment.dto.CommentDTO;
import taskmanager.database.comment.service.CommentService;

import javax.validation.Valid;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CommentMutationResolver implements GraphQLMutationResolver {

    private final CommentService service;

    public Long deleteCommentById(Long existingId) {
        service.deleteById(existingId);
        return existingId;
    }

    public CommentDTO saveComment(@Valid CommentDTO request) {
        return service.save(request);
    }

//    public CommentDTO updateComment(Long existingId, @Valid CommentDTO request) {
//        return service.update(existingId, request);
//    }

}
