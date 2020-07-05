package taskmanager.database.task.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import taskmanager.database.task.domain.Task;
import taskmanager.database.task.dto.TaskDTO;
import taskmanager.database.task.exception.TaskNotFoundException;
import taskmanager.database.task.mapper.TaskMapper;
import taskmanager.database.task.repository.TaskRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    private final TaskMapper mapper;

    @Transactional
    public void deleteById(Long existingId) {
        if (taskNotFound(existingId))
            throw new TaskNotFoundException(String.format("Task with id: %d, wasn't found!", existingId));

        repository.deleteById(existingId);
    }

    private boolean taskNotFound(Long existingId) {
        return repository.findById(existingId).isEmpty();
    }

    @Transactional
    public TaskDTO save(TaskDTO request) {
        Task savedEntity = repository.save(mapper.toEntity(request));
        return mapper.toDTO(savedEntity);
    }

    @Transactional
    public TaskDTO update(Long existingId, TaskDTO request) {
        TaskDTO foundTask = findById(existingId);
        foundTask.setName(request.getName());
        foundTask.setDescription(request.getDescription());
        foundTask.setSection(request.getSection());

        Task savedEntity = repository.save(mapper.toEntity(foundTask));
        return mapper.toDTO(savedEntity);
    }

    public TaskDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new TaskNotFoundException(
                        String.format("Task with id: %d, wasn't found!", id)
                ));
    }

    public List<TaskDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

}
