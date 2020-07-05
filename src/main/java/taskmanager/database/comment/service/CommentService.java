package taskmanager.database.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import taskmanager.database.comment.domain.Comment;
import taskmanager.database.comment.dto.CommentDTO;
import taskmanager.database.comment.exception.CommentNotFoundException;
import taskmanager.database.comment.mapper.CommentMapper;
import taskmanager.database.comment.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

    private final CommentMapper mapper;

    @Transactional
    public void deleteById(Long existingId) {
        if (commentNotFound(existingId))
            throw new CommentNotFoundException(String.format("Comment with id: %d, was't found!", existingId));

        repository.deleteById(existingId);
    }

    private boolean commentNotFound(Long existingId) {
        return repository.findById(existingId).isEmpty();
    }

    @Transactional
    public CommentDTO save(CommentDTO request) {
        Comment savedEntity = repository.save(mapper.toEntity(request));
        return mapper.toDTO(savedEntity);
    }

//    no need for an update method at this time
//    @Transactional
//    public CommentDTO update(Long existingId, CommentDTO request) {
//        CommentDTO foundComment = findById(existingId);
//        // setters
//        Comment savedEntity = repository.save(mapper.toEntity(foundComment));
//        return mapper.toDTO(savedEntity);
//    }

    public CommentDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new CommentNotFoundException(
                        String.format("Comment with id: %d, wasn't found!", id)
                ));
    }

    public List<CommentDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

}
