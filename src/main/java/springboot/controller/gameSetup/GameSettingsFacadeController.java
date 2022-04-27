package springboot.controller.gameSetup;

import springboot.controller.BoardController;
import springboot.model.Complexity;
import springboot.model.GameSettings;
import springboot.model.players.Player;
import springboot.controller.ApplicationController;
import springboot.model.cards.CardDeck;
import springboot.model.players.PlayerFactory;
import springboot.view.gameSetupViews.GameSettingsView;
import springboot.model.board.Board;


import java.beans.PropertyChangeSupport;
import java.util.Set;


public class GameSettingsFacadeController {

    private PropertyChangeSupport support;
    private BoardSetupController boardSetupController;
    private PlayerSetupController playerSetupController;
    private BoardPositionController boardPositionController;
    private BoardController boardController;
    private ApplicationController application;
    private Board board;
    private Set<Player> sps;
    private GameSettings gameSettings;
    private GameSettingsView view;
    private CardDeck cardDeck;
    //private CardDeck deck;

    public GameSettingsFacadeController(ApplicationController application) {
        super();
        this.support = new PropertyChangeSupport(this);
        this.application = application;
        this.view = new GameSettingsView(this);
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public void setGameSettings(Complexity complexity, int noPlayers) {
        gameSettings = new GameSettings();
        this.gameSettings.setComplexity(complexity);
        this.gameSettings.setAmountOfPlayers(noPlayers);
    }

    public void setupGame(Complexity complexity, int noPlayers) {
        System.out.println("Game Started!");
        gameSettings = new GameSettings();
        gameSettings.setComplexity(complexity);
        gameSettings.setAmountOfPlayers(noPlayers);

        boardSetupController = new BoardSetupController(this);
        boardSetupController.display();
    }

    public void setupBoard(){
        System.out.println("Board has been selected");

        boardController = BoardController.getInstance(this);

        cardDeck = new CardDeck();

        playerSetupController = new PlayerSetupController(this, gameSettings.getAmountOfPlayers());
        playerSetupController.display();
    }


    public void setupPlayers(Set<String> names) {
        System.out.println("Players have been initialized");
        sps = PlayerFactory.getPlayerSet(gameSettings.getAmountOfPlayers(), names);

        boardPositionController = new BoardPositionController(this, boardController, gameSettings.getAmountOfPlayers(), sps);
        boardPositionController.display();
    }

    public void selectPositions(Set<Player> sps, BoardController boardController) {
        gameSettings.setPlayers(sps);
        application.game(boardController, gameSettings, cardDeck);
    }

    //Display the view
    public void display() {view.setVisible(true);}

}
