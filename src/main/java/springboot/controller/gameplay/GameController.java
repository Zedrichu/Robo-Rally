package springboot.controller.gameplay;

import springboot.controller.ApplicationController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.CardDeck;
import springboot.view.HealthView;
import springboot.view.gameplay.GameView;

public class GameController {
    private ApplicationController application;
    private GameView gameView;
    private HealthView healthView;
    private GameSettings settings;


    public GameController(ApplicationController application, GameSettings gameSettings, Board board, CardDeck deck){
        this.application = application;
        this.healthView = new HealthView(this,gameSettings);


    }

    public void display(){ healthView.setVisible(true); }


}
