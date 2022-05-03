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
import springboot.model.Round;
import springboot.view.gameplay.LogView;

import javax.swing.*;
import java.beans.PropertyChangeSupport;
import java.util.Set;

/**
 * Facade controller class handling the gameplay in the application.
 */
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

    /**
     * Board Getter
     * @return Board object storing the current state of the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Round Getter
     * @return Round object storing the current round in the game
     */
    public Round getRound() {
        return round;
    }

    /**
     * Class constructor setting up the board, deck, round, observer support.
     * @param gameSettings - GameSettings entity
     * @param board - Board object, current board to be played
     * @param deck - CardDeck used for card drawing
     */
    public GameController(GameSettings gameSettings, Board board, CardDeck deck){
        this.support = new PropertyChangeSupport(this);
        this.board = board;
        this.deck = deck;
        this.logView = new LogView();// Yet to be implemented
        this.round = new Round(gameSettings.getPlayers());
        startGame();
    }

    /**
     * Method preparing the next round with all the required checks and initializations.
     */
    public void nextRound(){
        //Play cards for each player in set of players
        for (Player player : this.round.getPlayers()) {
            for (int i = 0; i < player.getHand().size(); i++) {
                // Remove the robot from previous position
                board.getTile(player.getCoordinates()).setRobotOnTop(false,player.getDirection());
                board.getTile(player.getCoordinates()).setRobotIcon(null);
                // Obtain the next card to be played
                Card card = player.getHand().get(i);
                // Card may be null if player touches the pit and loses the next card
                if (card != null) {
                    // Play the current card and move the robot accordingly
                    player.playCard(player.getHand().get(i), this.board);

                }
                // Obtain the obstacle on which the player is placed, if there is one
                Obstacle obstacle = this.board.getTile(player.getCoordinates()).getType().getObstacle();
                if (obstacle != null) {
                    // Hit the obstacle and take the corresponding damage
                    player.hitObstacle(this.board, this.round.getRoundNumber());
                    // If a player runs out of lives, it gets removed from the set of players in game.
                    if (player.getLives()<=0){
                        this.round.getPlayers().remove(player);
                    }
                    // If a player has collected all the checkpoints on the board, is declared winner
                    else if (player.hasAllCP(this.board.getCheckPoints())) {
                        System.out.println("Winner "+player.getPlayerName());
                        this.gameView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        JOptionPane.showMessageDialog(gameView, "Winner is "+player.getPlayerName()+"!");
                        //this.gameView.dispose();
                    }
                }
                // Place the robot on the new position
                board.getTile(player.getCoordinates()).setRobotOnTop(true, player.getDirection());
                board.getTile(player.getCoordinates()).setRobotIcon(player.getRobot());
            }
            // After using the cards, restore the hand back to the deck and shuffle the cards.
            this.deck.restoreCards(player.hand.getHand());
        }
        // Increments round and sends property change to game view
        this.round.resetRound();

        // Remove the elements currently placed on views
        this.gameView.removeAll();
        this.boardView.removeAll();
        this.healthView.removeAll();
        this.support.removePropertyChangeListener(this.gameView);
        this.gameView.dispose();

        // Update the views
        this.board = this.boardView.getBoard();
        this.setHealthView(this.round);
        this.setBoardView(this.board, this.round.getPlayers());
        this.tableController.nextRound();
        this.tableController.nextPlayer();
        this.gameView = new GameView(this, tableController, this.healthView, this.boardView, this.logView);
        this.support.addPropertyChangeListener(gameView);
        this.gameView.setVisible(true);
        support.firePropertyChange("nextRound", round.getRoundNumber()-1, round.getRoundNumber());
    }

    /**
     * Method to start the game after selecting settings.
     */
    public void startGame() {
        setHealthView(this.round);
        setBoardView(this.board, this.round.getPlayers());
        // Update the table controller
        this.tableController = new TableController(this.support, this, this.round, this.deck);
        this.gameView = new GameView(this, tableController, this.healthView, this.boardView,this.logView);
        this.support.addPropertyChangeListener(gameView);
    }

    /**
     * BoardView Setter
     * @param board - Board object holding the state of the game board
     * @param sps - Set of players included in the game
     */
    public void setBoardView(Board board, Set<Player> sps) {
        this.boardView = new BoardView(board, sps);
    }

    /**
     * HealthView Setter
     * @param round - Round object holding the current game round
     */
    public void setHealthView(Round round) {
        this.healthView = new HealthView(round);
    }

    /**
     * Method to make the corresponding view of the controller visible.
     */
    public void display(){ gameView.setVisible(true); }
}
