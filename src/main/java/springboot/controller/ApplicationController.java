package springboot.controller;

import game.Complexity;
import game.GameSettings;

public class ApplicationController {

    private GameSettingsController settingsController;
    private BoardSetupController boardController;
    private CardController cardController;
    private PlayerSetupController playerSetupController;

    public void settings() {
        settingsController = new GameSettingsController(this);
        settingsController.display();
    }


    public void playerSetup(){
        //PlayerSetupController needs modifiation, the noPlayers should be from the settings
        //Have tried with getNoPlayers() from GameSettingsController, but it is not working
        playerSetupController = new PlayerSetupController(this,2);
        playerSetupController.display();
    }

    // public void setupBoard(Complexity complexity, int noPlayers) {
    //    boardController = new BoardSetupController(this,complexity,noPlayers);
    //   boardController.display();
    //}



    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.settings();
    }

}
