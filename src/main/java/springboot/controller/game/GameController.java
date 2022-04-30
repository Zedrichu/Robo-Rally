package springboot.controller.game;

import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.CardDeck;
import springboot.model.players.Player;
import springboot.view.gameplay.HealthView;
import springboot.view.boardInterface.BoardView;
import springboot.view.gameplay.GameView;
import springboot.model.round.Round;

import java.beans.PropertyChangeSupport;
import java.util.Set;

public class GameController {

    private PropertyChangeSupport support;
    private TableController tableController;
    private GameView gameView;
    private HealthView healthView;
    private BoardView boardView;
    private final Round round;
    private final Board board;

    public Board getBoard() {
        return board;
    }

    public Round getRound() {
        return round;
    }

    public GameController(GameSettings gameSettings, Board board, CardDeck deck){
        this.support = new PropertyChangeSupport(this);
        board.placePlayers(gameSettings.getPlayers());
        this.board = board;
        this.round = new Round(gameSettings.getPlayers());
        startGame(deck);
    }

    public GameView getGameView() {
        return gameView;
    }

    public void nextRound(){
        //for (Player player : round.getPlayers()) {
        //    player.playCard(player.getHand(), board);
        //}
    }

    public void startGame(CardDeck deck) {
        setHealthView(this.round);
        setBoardView(this.board, this.round.getPlayers());
        this.tableController = new TableController(this.support,this, this.round, deck);
        this.gameView = new GameView(this, this.tableController, this.healthView, this.boardView);
        this.support.addPropertyChangeListener(gameView);
    }

    public void setBoardView(Board board, Set<Player> sps) {
        this.boardView = new BoardView(board, sps);
    }

    public void setHealthView(Round round) {
        this.healthView = new HealthView(round);
    }

    public void display(){ gameView.setVisible(true); }
}
