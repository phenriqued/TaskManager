package phenrique.com.github.Repositories;

import phenrique.com.github.Model.Entity.Task.TaskEntity;

import java.util.List;

public interface TaskRepository {

    void createTask(TaskEntity task);
    List<TaskEntity> findAll();
    TaskEntity findById(Long Id);
    void updateTask(Long id, TaskEntity task);
    void deleteTask(Long id);



}
