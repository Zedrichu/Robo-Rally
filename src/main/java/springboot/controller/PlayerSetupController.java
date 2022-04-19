package springboot.controller;

import springboot.view.PlayerSetupView;

public class PlayerSetupController {
    private ApplicationController application;
    private int noPlayers;
    private PlayerSetupView view;

    public PlayerSetupController(ApplicationController application, int noPlayers){
        this.application = application;
        this.noPlayers = noPlayers;
    }




    public void startGame() {}

    public void display(){view.setVisible(true);}

}
