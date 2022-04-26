package springboot.controller;

import springboot.controller.ApplicationController;
import springboot.controller.BoardController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.CardDeck;
import springboot.view.HealthView;
import springboot.view.boardViews.BoardView;
import springboot.view.cardViews.CardTableView;
import springboot.view.gameplay.GameView;
import springboot.model.round.Round;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameController {
    private final PropertyChangeSupport support;
    private CardTableController cardTableController;
    private GameView gameView;
    private HealthView healthView;
    private BoardView boardView;
    private Round round;
    private Board board;

    public Board getBoard() {
        return board;
    }

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
        setBoard(board);
        setRound(round);
        //setDeck(deck);
        this.healthView = new HealthView(gameSettings.getPlayers());
        this.boardView = new BoardView(BoardController.getInstance(this), this.board);
        this.cardTableController = new CardTableController(application,deck);
        this.gameView = new GameView(this, cardTableController, healthView, boardView);
    }

    public void display(){ gameView.setVisible(true); }

}
