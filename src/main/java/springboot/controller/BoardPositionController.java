package springboot.controller;


import springboot.view.BoardPositionView;
import springboot.view.BoardSetupView;
import view.widgets.Board;

public class BoardPositionController {
    private BoardPositionView view;
    private GameSettingsController gameSettingsController;

    public BoardPositionController(GameSettingsController gameSettingsController, Board board, int noPlayers) {
        this.gameSettingsController = gameSettingsController;
        this.view = new BoardPositionView(gameSettingsController, board, noPlayers);
    }


    public void display(){view.setVisible(true);}



}
