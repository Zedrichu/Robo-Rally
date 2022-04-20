package springboot.controller;

import springboot.view.PlayerSetupView;

public class PlayerSetupController {
    private GameSettingsController gameSettingsController;
    private PlayerSetupView view;

    public PlayerSetupController(GameSettingsController gameSettingsController, int noPlayers){
        this.gameSettingsController = gameSettingsController;
        this.view = new PlayerSetupView(gameSettingsController, noPlayers);
    }

    public void display(){view.setVisible(true);}

}
