package springboot.controller.gameSetup;

import springboot.view.gameSetupViews.PlayerSetupView;

import java.util.Set;

public class PlayerSetupController {
    private GameSettingsFacadeController gameSettingsController;
    private PlayerSetupView view;

    public PlayerSetupController(GameSettingsFacadeController gameSettingsController, int noPlayers){
        this.gameSettingsController = gameSettingsController;
        this.view = new PlayerSetupView(gameSettingsController, this, noPlayers);
    }

    public boolean validateNames(Set<String> names, int noPlayers){
        return names.size() == noPlayers;
    }


    public void display(){view.setVisible(true);}

}
