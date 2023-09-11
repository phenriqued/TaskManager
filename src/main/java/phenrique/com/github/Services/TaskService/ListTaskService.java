package phenrique.com.github.Services.TaskService;

import phenrique.com.github.Exceptions.TaskException;
import phenrique.com.github.Model.Entity.Task.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class ListTaskService {

    private static List<TaskEntity> taskEntityList = new ArrayList<>();

    public static void addTask(TaskEntity taskEntity){
        taskEntityList.add(taskEntity);
    }

    public static List<TaskEntity> getAllTask(){
        return taskEntityList;
    }

    public static TaskEntity getByIdTask(Long id){
        if(id == null) throw new TaskException("Id cannot be null!");

        for (TaskEntity task : getAllTask()){
            if(task.getId() == id){
                return task;
            }
        }
        throw new TaskException("There is no task with this Id.");
    }

    public static void updateTask(Long id, TaskEntity task){
        TaskEntity updateTask = getByIdTask(id);

        updateTask.setDescription(task.getDescription());
        updateTask.setStatus(task.getStatus());
        updateTask.setEndDate(task.getEndDate());
    }

    public static void deleteTask(Long id){
        TaskEntity deleteTask = getByIdTask(id);
        taskEntityList.remove(deleteTask);
    }

}
