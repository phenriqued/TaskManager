package phenrique.com.github.Controller;

import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Services.TaskService.TaskService;
import phenrique.com.github.View.InterfaceUI.UITaskInterface;

import java.util.Date;
import java.util.List;

public class TaskController implements UITaskInterface {

    private TaskService taskService;

    public TaskController() {
        this.taskService = new TaskService();
    }
    @Override
    public void createTask(String description, String date) {
        Date dueDate = TaskEntity.parseFormat(date);
        TaskEntity myTask = new TaskEntity(description, dueDate);
        taskService.createTask(myTask);
    }

    @Override
    public List<TaskEntity> findAll(){
        return taskService.findAll();
    }
    @Override
    public TaskEntity findById(Long id){
        return taskService.findById(id);
    }
    @Override
    public void updateTask(Long id, TaskEntity task){
        taskService.updateTask(id, task);
    }

    @Override
    public void deleteTask(Long id){
        taskService.deleteTask(id);
    }


}
