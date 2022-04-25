package springboot.controller;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.controller.gameSetup.PlayerSetupController;

public class ApplicationController {

    private GameSettingsFacadeController settingsController;
    private CardController cardController;
    private PlayerSetupController playerSetupController;
    //private RunningGameController runningGameController;

    public void game(){
        //runningGameController = new RunningGameController(this);

    }

    public void settings() {
        settingsController = new GameSettingsFacadeController(this);
        settingsController.display();
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.settings();
    }

}
