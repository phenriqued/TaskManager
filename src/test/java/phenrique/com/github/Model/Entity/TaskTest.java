package phenrique.com.github.Model.Entity;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import phenrique.com.github.Controller.TaskController;
import phenrique.com.github.Exceptions.TaskException;
import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.Model.Util.ConnectionUtil.ConnectionUtil;
import phenrique.com.github.Services.TaskService.TaskService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private static TaskController taskController;
    private static EntityManager entityManager;
    private static EntityTransaction transaction;

    @BeforeAll
    static void setup(){
        ConnectionUtil connectionUtil = new ConnectionUtil();
        entityManager = connectionUtil.recoverEntityManager();
        taskController = new TaskController(new TaskService());
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @AfterAll
    static void teardown(){
        if (transaction.isActive()) {
            transaction.rollback();
        }
        entityManager.close();
    }

    @Test
    @DisplayName("User must be able to create a new task")
    void createNewUserTasks(){
        taskController.createTask("descriptionCreate", "12/12/2025");

        List<TaskEntity> tasks = entityManager.createQuery("SELECT tasks FROM TaskEntity tasks", TaskEntity.class)
                .getResultList();

        assertFalse(tasks.isEmpty());
        tasks.forEach(System.out::println);
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
        List<TaskEntity> tasks = entityManager.createQuery("SELECT tasks FROM TaskEntity tasks", TaskEntity.class)
                .getResultList();
        TaskEntity newTask = new TaskEntity("change this description", TaskEntity.parseFormat("12/12/2025"));
        taskController.updateTask(tasks.get(0).getId(),newTask);


        assertEquals(taskController.findById(tasks.get(0).getId()).getDescription(), "change this description");
    }

    @Test
    @DisplayName("User must be able to delete a exist task")
    void deleteTask(){
        List<TaskEntity> tasks = entityManager.createQuery("SELECT tasks FROM TaskEntity tasks", TaskEntity.class)
                .getResultList();
        assertEquals(tasks.size(), taskController.findAll().size());

        taskController.deleteTask(tasks.get(1).getId());
        assertEquals(tasks.size()-1, taskController.findAll().size());
    }

    @Test
    @DisplayName("User can be able to list all his tasks")
    void listAllTask(){
        assertEquals(taskController.findAll(), entityManager.createQuery("SELECT t FROM TaskEntity t", TaskEntity.class).getResultList());
    }





}