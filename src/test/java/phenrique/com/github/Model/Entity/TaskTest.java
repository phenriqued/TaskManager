package phenrique.com.github.Model.Entity;


import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import phenrique.com.github.Controller.TaskController;

public class TaskTest {

    private TaskController taskController;

    @BeforeEach
    void initializer(){
        taskController = new TaskController();
    }

    @Test
    @DisplayName("User can create new task!")
    void createNewUserTasks(){
        taskController.createTask("description", "12/09/2023");
        Assert.assertEquals(1, UITask.taskList.size());
    }

}