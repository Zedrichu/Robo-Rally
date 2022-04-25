package springboot.controller;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.controller.gameSetup.PlayerSetupController;
import springboot.controller.gameplay.GameController;

public class ApplicationController {

    private GameSettingsFacadeController settingsController;
    private CardController cardController;
    private PlayerSetupController playerSetupController;
    private GameController gameController;

    public void game(){
        gameController = new GameController(this);
        gameController.display();
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
