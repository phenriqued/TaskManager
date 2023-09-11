package phenrique.com.github.Controller;

import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Services.TaskService.TaskService;

import java.util.Date;
import java.util.List;

public class TaskController {

    private TaskService taskService;

    public TaskController() {
        this.taskService = new TaskService();
    }

    public void createTask(String description, String date) {
        Date dueDate = TaskEntity.parseFormat(date);
        TaskEntity myTask = new TaskEntity(description, dueDate);
        taskService.createTask(myTask);
    }

    public List<TaskEntity> findAll(){
        return taskService.findAll();
    }
    public TaskEntity findById(Long id){
        return taskService.findById(id);
    }
    public void updateTask(Long id, TaskEntity task){
        taskService.updateTask(id, task);
    }

    public void deleteTask(Long id){
        taskService.deleteTask(id);
    }


}
