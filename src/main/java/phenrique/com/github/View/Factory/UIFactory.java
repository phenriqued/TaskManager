package phenrique.com.github.View.Factory;


import phenrique.com.github.Controller.TaskController;
import phenrique.com.github.Services.TaskService.TaskService;

public class UIFactory {


    public static TaskController factoryController(){
        return new TaskController(new TaskService());
    }
}
