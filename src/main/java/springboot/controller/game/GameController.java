package springboot.controller.game;

import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.Card;
import springboot.model.cards.CardDeck;
import springboot.model.obstacles.Obstacle;
import springboot.model.players.Player;
import springboot.view.gameplay.HealthView;
import springboot.view.boardInterface.BoardView;
import springboot.view.gameplay.GameView;
import springboot.model.round.Round;
import springboot.view.gameplay.LogView;

import java.beans.PropertyChangeSupport;
import java.util.Set;

public class GameController {

    private final LogView logView;
    private final PropertyChangeSupport support;
    private GameView gameView;
    private HealthView healthView;
    private BoardView boardView;
    private final Round round;
    private final Board board;
    private final CardDeck deck;

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
        this.deck = deck;
        this.logView = new LogView();
        this.round = new Round(gameSettings.getPlayers());
        startGame(deck);
    }

    public void nextRound(){
        //Play cards for each player in set of players
        for (Player player : round.getPlayers()) {
            for (int i = 0; i < player.getHand().size(); i++) {
                player.playCard(player.getHand().get(i), board);
                Obstacle obstacle = board.getTile(player.getCoordinates()).getType().getObstacle();
                if (obstacle != null) {
                    player.hitObstacle(board.getTile(player.getCoordinates()).getType().getObstacle(), round.getRoundNumber());
                }
            }
            this.deck.restoreCards(player.hand.getHand());
        }
        //Increments round and sends property change to game view
        round.incrementRoundNumber();
        this.setBoardView(this.board, this.round.getPlayers());
        this.setHealthView(this.round);
        support.firePropertyChange("nextRound", round.getRoundNumber()-1, round.getRoundNumber());


    }

    public GameView getGameView() {
        return gameView;
    }

    public void startGame(CardDeck deck) {
        setHealthView(this.round);
        setBoardView(this.board, this.round.getPlayers());
        TableController tableController = new TableController(this.support, this, this.round, deck);
        this.gameView = new GameView(this, tableController, this.healthView, this.boardView,this.logView);
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
