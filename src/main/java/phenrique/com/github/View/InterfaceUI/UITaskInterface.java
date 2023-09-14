package phenrique.com.github.View.InterfaceUI;

import phenrique.com.github.Model.Entity.Task.TaskEntity;

import java.util.List;

public interface UITaskInterface {

    void createTask(String description, String date);
    List<TaskEntity> findAll();
    TaskEntity findById(Long Id);
    TaskEntity updateTask(Long id, TaskEntity update);
    void deleteTask(Long id);

}
