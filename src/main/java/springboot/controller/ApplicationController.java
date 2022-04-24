package springboot.controller;

import game.Complexity;
import game.GameSettings;

public class ApplicationController {

    private GameSettingsController settingsController;
    private CardController cardController;
    private PlayerSetupController playerSetupController;
    //private RunningGameController runningGameController;

    public void game(){
        //runningGameController = new RunningGameController(this);

    }

    public void settings() {
        settingsController = new GameSettingsController(this);
        settingsController.display();
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.settings();
    }

}
