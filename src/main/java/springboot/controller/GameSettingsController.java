package springboot.controller;

import game.Complexity;
import game.GameSettings;
import org.springframework.stereotype.Controller;
import springboot.Application;
import springboot.view.GameSettingsView;


public class GameSettingsController {

    private ApplicationController application;
    private GameSettings gameSettings;
    private GameSettingsView view;

    GameSettingsController(ApplicationController application) {
        this.application = application;
        this.view = new GameSettingsView(this);
    }

    public void setupBoard(Complexity complexity, int noPlayers) {
        System.out.println("Game Started!");
        gameSettings = new GameSettings();
        gameSettings.setComplexity(complexity);
        gameSettings.setAmountOfPlayers(noPlayers);
    }

    //Getter from Model to Controller
    public Complexity getGameComplexity() {
        return gameSettings.getComplexity();
    }
    public int getNoPlayers() {
        return gameSettings.getAmountOfPlayers();
    }
    //Display the view
    public void display() {view.setVisible(true);}

}
