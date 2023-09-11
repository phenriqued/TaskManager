package phenrique.com.github.Model.Entity;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import phenrique.com.github.Controller.TaskController;
import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Services.TaskService.ListTaskService;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    private static TaskController taskController;

    @BeforeAll
    static void initializer(){
        taskController = new TaskController();
    }

    @Test
    @DisplayName("User must be able to create a new task")
    void createNewUserTasks(){
        taskController.createTask("description", "12/09/2023");
        assertEquals(1, ListTaskService.getAllTask().size());
    }

    @Test
    @DisplayName("User must be able to update a exist task")
    void updateTask(){
        createTaskForUpdateAndDeleteTest();
        TaskEntity newTask = new TaskEntity("changing this description", Date.from(Instant.now()));
        taskController.updateTask(0l, newTask);
        assertEquals("changing this description", ListTaskService.getByIdTask(0l).getDescription());

    }
    private void createTaskForUpdateAndDeleteTest(){
        taskController.createTask("description", "12/09/2023");
    }

    @Test
    @DisplayName("User must be able to delete a exist task")
    void deleteTask(){
        createTaskForUpdateAndDeleteTest();
        assertEquals(taskController.findAll().size(), 3);
        taskController.deleteTask(1l);
        assertEquals(taskController.findAll().size(), 2);
    }

    @Test
    @DisplayName("User can be able to list all his tasks")
    void listAllTask(){
        assertEquals(taskController.findAll(), ListTaskService.getAllTask());
    }





}