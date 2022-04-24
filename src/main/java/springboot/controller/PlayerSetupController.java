package springboot.controller;

import springboot.view.PlayerSetupView;

import java.util.Set;

public class PlayerSetupController {
    private GameSettingsController gameSettingsController;
    private PlayerSetupView view;

    public PlayerSetupController(GameSettingsController gameSettingsController, int noPlayers){
        this.gameSettingsController = gameSettingsController;
        this.view = new PlayerSetupView(gameSettingsController, this, noPlayers);
    }

    public boolean validateNames(Set<String> names, int noPlayers){
        return names.size() == noPlayers;
    }


    public void display(){view.setVisible(true);}

}
