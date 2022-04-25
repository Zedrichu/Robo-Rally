package springboot.controller.GameController;

import game.GameSettings;
import game.players.Player;
import springboot.controller.ApplicationController;
import springboot.view.GameView.GameView;
import view.widgets.Board;

import java.util.Set;

public class GameController {
    private ApplicationController application;
    private Board board;
    private Set<Player> sps;
    private GameSettings gameSettings;
    private GameView view;

    public GameController(ApplicationController application, GameSettings)

    public GameController(ApplicationController application){
        this.application = application;
        this.view = new GameView(this);
    }

    public void display() {view.setVisible(true);}

}
