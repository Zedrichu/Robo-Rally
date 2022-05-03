package springboot.controller.setup;

import springboot.controller.game.BoardController;
import springboot.model.Complexity;
import springboot.model.GameSettings;
import springboot.model.players.Player;
import springboot.controller.ApplicationController;
import springboot.model.cards.CardDeck;
import springboot.model.players.PlayerFactory;
import springboot.view.setupInterfaces.GameSettingsView;
import springboot.model.board.Board;
import java.util.Set;

/**
 * Facade controller class unifying all the game settings together and preparing the data for the game
 *      - Client of the Player Factory
 * @author Adrian Zvizdenco & Jeppe Mikkelsen
 */
public class GameSettingsController {

    private final ApplicationController application; //Link to outer facade controller
    private BoardController boardController;
    private GameSettings gameSettings;
    private final GameSettingsView view;
    private CardDeck cardDeck;

    /**
     * Initialize the application controller and create a corresponding view.
     * @param application - ApplicationController, to create link with other facades in the application
     */
    public GameSettingsController(ApplicationController application) {
        this.application = application;
        this.view = new GameSettingsView(this);
    }

    /**
     * Game Settings Getter
     * @return object of GameSettings
     */
    public GameSettings getGameSettings() {
        return gameSettings;
    }

    /**
     * Game Settings Setter
     * @param complexity - enum type defining game complexity (EASY, MEDIUM, HARD).
     * @param noPlayers - positive integer, defining the number of players in the game.
     */
    public void setGameSettings(Complexity complexity, int noPlayers) {
        this.gameSettings = new GameSettings();
        this.gameSettings.setComplexity(complexity);
        this.gameSettings.setAmountOfPlayers(noPlayers);
    }

    /**
     * Handle the selection of complexity and number of players and pass on to board setup.
     * @param complexity - enum type defining game complexity (EASY, MEDIUM, HARD).
     * @param noPlayers - positive integer, defining the number of players in the game.
     */
    public void setupGame(Complexity complexity, int noPlayers) {
        System.out.println("Game Started!");
        this.setGameSettings(complexity, noPlayers);

        // Ready to set up the board with selected information
        BoardSetupController boardSetupController = new BoardSetupController(this);
        boardSetupController.display();
    }

    /**
     * Handle the selection of the board on which the game would be played.
     * @param board - Board object, initialized with the contents of the selected board.
     */
    public void setupBoard(Board board){
        System.out.println("Board has been selected");
        this.boardController = new BoardController(board, Set.of());
        // Create the card deck to be used in the game.
        this.cardDeck = new CardDeck();

        PlayerSetupController playerSetupController = new PlayerSetupController(this, gameSettings.getAmountOfPlayers());
        playerSetupController.display();
    }

    /**
     * Handle the selection of unique player names and creating the players, being a client of PLayerFactory
     * @param names - Set of unique player names, used for generating players from factory
     */
    public void setupPlayers(Set<String> names) {
        System.out.println("Players have been initialized");
        // Request PlayerFactory a set of players based on the set of names provided.
        Set<Player> sps = PlayerFactory.getPlayerSet(gameSettings.getAmountOfPlayers(), names);

        StartPositionController startPositionController = new StartPositionController(this, boardController, gameSettings.getAmountOfPlayers(), sps);
        startPositionController.display();
    }

    /**
     * Handle the selection of starting position on the board
     * @param sps - Set of players registered in the game.
     * @param boardController - Controller of the board in use.
     */
    public void selectPositions(Set<Player> sps, BoardController boardController) {
        gameSettings.setPlayers(sps);
        application.game(boardController, gameSettings, cardDeck);
    }

    /**
     * Method to make the corresponding view of the controller visible.
     */
    public void display() {view.setVisible(true);}

}
