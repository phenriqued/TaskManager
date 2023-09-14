package phenrique.com.github;

import phenrique.com.github.View.Factory.UIFactory;
import phenrique.com.github.View.UI;

public class Main {
    public static void main(String[] args) {
        UI userInterface = new UI(UIFactory.factoryController());
        userInterface.printDisplay();

    }
}