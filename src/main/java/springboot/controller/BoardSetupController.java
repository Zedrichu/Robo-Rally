package springboot.controller;

import game.Complexity;
import game.GameSettings;
import springboot.view.BoardSetupView;
import view.widgets.Board;

public class BoardSetupController {

    private BoardSetupView view;
    private GameSettingsController settingsController;

    public BoardSetupController(GameSettingsController settingsController){
        this.settingsController = settingsController;
        this.view = new BoardSetupView(settingsController);
    }

    public void display(){
        view.setVisible(true);
    }
}
