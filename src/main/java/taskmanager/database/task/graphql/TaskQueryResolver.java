package taskmanager.database.task.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import taskmanager.database.task.dto.TaskDTO;
import taskmanager.database.task.service.TaskService;

import java.util.List;

@Slf4j
@Component
@Validated
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class TaskQueryResolver implements GraphQLQueryResolver {

    private final TaskService service;

    public TaskDTO findTaskById(Long id) {
        return service.findById(id);
    }

    public List<TaskDTO> findAllTasks() {
        return service.findAll();
    }

}
