package springboot.controller.setup;

import springboot.view.setupInterfaces.BoardSetupView;

public class BoardSetupController {
    private final BoardSetupView view;

    public BoardSetupController(GameSettingsFacadeController settingsController){
        this.view = new BoardSetupView(settingsController);
    }

    public void display(){
        view.setVisible(true);
    }
}
