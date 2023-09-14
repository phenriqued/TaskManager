package phenrique.com.github.Controller;


import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Services.TaskService.TaskService;
import phenrique.com.github.View.InterfaceUI.UITaskInterface;

import java.time.LocalDate;
import java.util.List;


public class TaskController implements UITaskInterface {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @Override
    public void createTask(String description, String date) {
        LocalDate dueDate = TaskEntity.parseFormat(date);
        TaskEntity myTask = new TaskEntity(description, dueDate);
        taskService.save(myTask);
    }

    @Override
    public List<TaskEntity> findAll(){
        return taskService.toListAll();
    }
    @Override
    public TaskEntity findById(Long id){
        return taskService.findById(id);
    }
    @Override
    public TaskEntity updateTask(Long id, TaskEntity task){
        return taskService.update(id, task);
    }

    @Override
    public void deleteTask(Long id){
        TaskEntity removeTask = findById(id);
        taskService.remove(removeTask);
    }


}
