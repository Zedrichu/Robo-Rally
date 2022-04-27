package springboot.controller.gameSetup;

import springboot.view.gameSetupViews.BoardSetupView;

import java.beans.PropertyChangeSupport;

public class BoardSetupController {

    private BoardSetupView view;
    private GameSettingsFacadeController settingsController;

    public BoardSetupController(GameSettingsFacadeController settingsController, PropertyChangeSupport support){
        this.settingsController = settingsController;
        this.view = new BoardSetupView(settingsController, support);
    }

    public void display(){
        view.setVisible(true);
    }
}
