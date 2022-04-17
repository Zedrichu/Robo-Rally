package springboot.controller;

import game.Complexity;
import springboot.view.BoardSetupView;

public class BoardSetupController {
    private BoardSetupView view;
    private ApplicationController app;
    private Complexity complexity;
    private int noPlayers;

    public BoardSetupController(ApplicationController app, Complexity complexity, int noPlayers){
        this.app = app;
        this.complexity = complexity;
        this.noPlayers = noPlayers;
    }

    public void display(){
        view.setVisible(true);
    }
}
