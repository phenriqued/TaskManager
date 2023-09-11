package phenrique.com.github;

import phenrique.com.github.Controller.TaskController;
import phenrique.com.github.View.UI;

public class Main {
    public static void main(String[] args) {
        UI userInterface = new UI(new TaskController());
        userInterface.printDisplay();
    }
}