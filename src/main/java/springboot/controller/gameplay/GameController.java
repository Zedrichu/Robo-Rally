package springboot.controller.gameplay;

import springboot.controller.ApplicationController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.CardDeck;
import springboot.view.HealthView;
import springboot.view.gameplay.GameView;
import springboot.model.round.Round;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameController {
    private final PropertyChangeSupport support;
    private ApplicationController application;
    private GameView gameView;
    private HealthView healthView;
    private GameSettings settings;
    private Round round;
    private Board board;

    public void addPCL(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePCL(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setBoard(Board value) {
        support.firePropertyChange("board",this.board,value);
        System.out.println("Board updated!");
        this.board = value;
    }

    public void setRound(Round round) {
        support.firePropertyChange("round",this.round, round);
        System.out.println("Round updated!");
        this.round = round;
    }

    public GameController(ApplicationController application, GameSettings gameSettings, Board board, CardDeck deck){
        this.support = new PropertyChangeSupport(this);
        this.application = application;
        this.healthView = new HealthView(gameSettings);


    }

    public void display(){ healthView.setVisible(true); }


}
