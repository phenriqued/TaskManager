package phenrique.com.github.Model.Entity;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import phenrique.com.github.Controller.TaskController;
import phenrique.com.github.Exceptions.TaskException;
import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Services.TaskService.ListTaskService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTest {

    private static TaskController taskController;

    @BeforeAll
    static void initializer(){
        taskController = new TaskController();
    }

    @Test
    @DisplayName("User must be able to create a new task")
    void createNewUserTasks(){
        taskController.createTask("description", "12/09/2025");
        assertEquals(1, ListTaskService.getAllTask().size());
    }

    @Test
    @DisplayName("User can't not create a null or empty task and can't put a due date before now.")
    void ValidationsForCreatingTask(){
        assertThrows(NullPointerException.class, () -> taskController.createTask(null,"13/09/2025"));
        assertThrows(TaskException.class, () -> taskController.createTask("","13/09/2025"));

        assertThrows(TaskException.class, () -> taskController.createTask("description", "01/01/2020"));
    }



    @Test
    @DisplayName("User must be able to update a exist task")
    void updateTask(){
        createTaskForUpdateAndDeleteTest();
        TaskEntity newTask = new TaskEntity("changing this description", LocalDate.now());
        taskController.updateTask(0l, newTask);
        assertEquals("changing this description", ListTaskService.getByIdTask(0l).getDescription());

    }
    private void createTaskForUpdateAndDeleteTest(){
        taskController.createTask("description", "12/09/2025");
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