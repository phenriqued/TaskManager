package phenrique.com.github.Services.TaskService;

import phenrique.com.github.Exceptions.TaskException;
import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Repositories.TaskRepository;

import java.util.List;

public class TaskService implements TaskRepository {


    @Override
    public void createTask(TaskEntity task) {
        ListTaskService.addTask(task);
    }

    @Override
    public List<TaskEntity> findAll() {
        return ListTaskService.getAllTask();
    }

    @Override
    public TaskEntity findById(Long id) {
        return ListTaskService.getByIdTask(id);
    }

    @Override
    public void updateTask(Long id, TaskEntity task) {
        ListTaskService.updateTask(id, task);
    }

    @Override
    public void deleteTask(Long id) {
        ListTaskService.deleteTask(id);
    }

}
