package springboot.controller;

import game.Complexity;

public class ApplicationController {

    private GameSettingsController settingsController;
    private BoardSetupController boardController;

    public void settings() {
        settingsController = new GameSettingsController(this);
        settingsController.display();
    }

    public void setupBoard(Complexity complexity, int noPlayers) {
        boardController = new BoardSetupController(this,complexity,noPlayers);
        boardController.display();
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.settings();
    }

}
