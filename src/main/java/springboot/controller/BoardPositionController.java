package springboot.controller;


import game.players.Player;
import springboot.model.Position;
import springboot.view.BoardPositionView;
import springboot.view.BoardSetupView;
import view.widgets.Board;

import java.util.HashSet;
import java.util.Set;

public class BoardPositionController {
    private BoardPositionView view;
    private GameSettingsController gameSettingsController;

    public BoardPositionController(GameSettingsController gameSettingsController, Board board, int noPlayers, Set<Player> sps) {
        this.gameSettingsController = gameSettingsController;
        this.view = new BoardPositionView(gameSettingsController, this, board, noPlayers, sps);
    }


    public void display(){view.setVisible(true);}



}
