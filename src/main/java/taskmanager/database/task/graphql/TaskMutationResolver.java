package taskmanager.database.task.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.task.dto.TaskDTO;
import taskmanager.database.task.service.TaskService;

import javax.validation.Valid;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class TaskMutationResolver implements GraphQLMutationResolver {

    private final TaskService service;

    public Long deleteTaskById(Long existingId) {
        service.deleteById(existingId);
        return existingId;
    }

    public TaskDTO saveTask(@Valid TaskDTO request) {
        return service.save(request);
    }

    public TaskDTO updateTask(Long existingId, @Valid TaskDTO request) {
        return service.update(existingId, request);
    }

}
