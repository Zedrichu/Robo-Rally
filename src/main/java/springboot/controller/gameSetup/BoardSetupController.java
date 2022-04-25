package springboot.controller.gameSetup;

import springboot.view.gameSetupViews.BoardSetupView;

public class BoardSetupController {

    private BoardSetupView view;
    private GameSettingsFacadeController settingsController;

    public BoardSetupController(GameSettingsFacadeController settingsController){
        this.settingsController = settingsController;
        this.view = new BoardSetupView(settingsController);
    }

    public void display(){
        view.setVisible(true);
    }
}
