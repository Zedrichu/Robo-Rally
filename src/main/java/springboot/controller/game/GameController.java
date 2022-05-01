package springboot.controller.game;

import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.CardDeck;
import springboot.model.obstacles.Obstacle;
import springboot.model.players.Player;
import springboot.view.gameplay.HealthView;
import springboot.view.boardInterface.BoardView;
import springboot.view.gameplay.GameView;
import springboot.model.Round;
import springboot.view.gameplay.LogView;

import javax.swing.*;
import java.beans.PropertyChangeSupport;
import java.util.Set;

public class GameController {

    private final LogView logView;
    private final PropertyChangeSupport support;
    private GameView gameView;
    private HealthView healthView;
    private BoardView boardView;
    private final Round round;
    private Board board;
    private final CardDeck deck;
    private TableController tableController;

    public Board getBoard() {
        return board;
    }

    public Round getRound() {
        return round;
    }

    public GameController(GameSettings gameSettings, Board board, CardDeck deck){
        this.support = new PropertyChangeSupport(this);
        this.board = board;
        this.deck = deck;
        this.logView = new LogView();
        this.round = new Round(gameSettings.getPlayers());
        startGame();
    }

    public void nextRound(){
        System.out.println(""+this.round.getPlayers()+"-->"+this.round.getRoundNumber());


        //Play cards for each player in set of players
        for (Player player : this.round.getPlayers()) {
            for (int i = 0; i < player.getHand().size(); i++) {
                player.playCard(player.getHand().get(i), this.board);
                Obstacle obstacle = this.board.getTile(player.getCoordinates()).getType().getObstacle();
                if (obstacle != null) {
                    player.hitObstacle(this.board, this.round.getRoundNumber());
                    if (player.getLives()<=0){
                        this.round.getPlayers().remove(player);
                    }
                    else if (player.hasAllCP(this.board.getCheckPoints())) {
                        System.out.println("Winner "+player.getPlayerName());
                        this.gameView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        JOptionPane.showMessageDialog(gameView, "Winner is "+player.getPlayerName()+"!");
                        //this.gameView.dispose();

                    }
                }
            }
            this.deck.restoreCards(player.hand.getHand());
        }
        //Increments round and sends property change to game view
        this.round.resetRound();


        this.gameView.removeAll();
        this.boardView.removeAll();
        this.healthView.removeAll();
        this.board = this.boardView.getBoard();
        this.setHealthView(this.round);
        this.setBoardView(this.board, this.round.getPlayers());
        this.support.removePropertyChangeListener(this.gameView);
        this.gameView.dispose();
        this.tableController.nextRound();
        this.tableController.nextPlayer();
        this.gameView = new GameView(this, tableController, this.healthView, this.boardView, this.logView);
        this.support.addPropertyChangeListener(gameView);
        this.gameView.setVisible(true);

        support.firePropertyChange("nextRound", round.getRoundNumber()-1, round.getRoundNumber());


    }

    public GameView getGameView() {
        return gameView;
    }

    public void startGame() {
        setHealthView(this.round);
        setBoardView(this.board, this.round.getPlayers());
        tableController = new TableController(this.support, this, this.round, this.deck);
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
