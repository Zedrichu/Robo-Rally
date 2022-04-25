package springboot.controller.gameplay;

import springboot.controller.ApplicationController;
import springboot.model.GameSettings;
import springboot.view.GameView;
import springboot.view.HealthBarView;

public class GameController {
    private ApplicationController application;
    //private GameView view;
    private HealthBarView view;
    private GameSettings settings;


    public GameController(ApplicationController application){
        this.application = application;
        this.view = new HealthBarView(this);
    }

    public void display(){ view.setVisible(true); }


}
