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


public class GameSettingsFacadeController {

    private final ApplicationController application;
    private BoardController boardController;
    private GameSettings gameSettings;
    private final GameSettingsView view;
    private CardDeck cardDeck;

    // Initialize settings controller with app controller
    public GameSettingsFacadeController(ApplicationController application) {
        this.application = application;
        this.view = new GameSettingsView(this);
    }

    //Game settings getter
    public GameSettings getGameSettings() {
        return gameSettings;
    }

    //Setter for game settings with complexity and number of players
    public void setGameSettings(Complexity complexity, int noPlayers) {
        this.gameSettings = new GameSettings();
        this.gameSettings.setComplexity(complexity);
        this.gameSettings.setAmountOfPlayers(noPlayers);
    }
    //Set up the complexity level and the amount of players in game and go to BoardSetupView
    public void setupGame(Complexity complexity, int noPlayers) {
        System.out.println("Game Started!");
        this.setGameSettings(complexity, noPlayers);

        // Ready to set up the board with selected information
        BoardSetupController boardSetupController = new BoardSetupController(this);
        boardSetupController.display();
    }
    //Set up the board that generates the cardDock and goes to the PlayerSetupView
    public void setupBoard(Board board){
        System.out.println("Board has been selected");
        this.boardController = new BoardController(board, Set.of());
        this.cardDeck = new CardDeck();

        PlayerSetupController playerSetupController = new PlayerSetupController(this, gameSettings.getAmountOfPlayers());
        playerSetupController.display();
    }

    //Method that goes to StartPositionView
    public void setupPlayers(Set<String> names) {
        System.out.println("Players have been initialized");
        Set<Player> sps = PlayerFactory.getPlayerSet(gameSettings.getAmountOfPlayers(), names);

        StartPositionController startPositionController = new StartPositionController(this, boardController, gameSettings.getAmountOfPlayers(), sps);
        startPositionController.display();
    }

    //Method for going to gamePlay controller
    public void selectPositions(Set<Player> sps, BoardController boardController) {
        gameSettings.setPlayers(sps);
        application.game(boardController, gameSettings, cardDeck);
    }

    //Display the view
    public void display() {view.setVisible(true);}

}
