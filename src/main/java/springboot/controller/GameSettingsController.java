package springboot.controller;

import game.Complexity;
import game.GameSettings;
import game.players.Player;
import org.springframework.stereotype.Controller;
import springboot.Application;
import springboot.model.players.PlayerFactory;
import springboot.view.BoardSetupView;
import springboot.view.GameSettingsView;
import view.widgets.Board;


import java.util.Set;


public class GameSettingsController {

    private BoardSetupController boardSetupController;
    private PlayerSetupController playerSetupController;
    private BoardPositionController boardPositionController;
    private ApplicationController application;
    private Board board;
    private Set<Player> sps;
    private GameSettings gameSettings;
    private GameSettingsView view;
    //private CardDeck deck;

    public GameSettingsController(ApplicationController application) {
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
        int[] sizes = gameSettings.getBoardSize();
        board = new Board(sizes[0],sizes[1],gameSettings.getAmountOfPlayers());



        playerSetupController = new PlayerSetupController(this, gameSettings.getAmountOfPlayers());
        playerSetupController.display();
    }


    public void setupPlayers(Set<String> names) {
        System.out.println("Players have been initialized");
        sps = PlayerFactory.getPlayerSet(gameSettings.getAmountOfPlayers(), names);
        boardPositionController = new BoardPositionController(this, board, gameSettings.getAmountOfPlayers(), sps);
        boardPositionController.display();
    }

    //Display the view
    public void display() {view.setVisible(true);}

}
