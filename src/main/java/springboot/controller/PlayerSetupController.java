package springboot.controller;

public class PlayerSetupController {
    private ApplicationController application;
    private int noPlayers;

    public PlayerSetupController(ApplicationController application, int noPlayers){
        this.application = application;
        this.noPlayers = noPlayers;
    }

    public void startGame() {}


}
