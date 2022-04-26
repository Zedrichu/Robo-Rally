package springboot.controller.gameSetup;


import springboot.controller.BoardController;
import springboot.model.Position;
import springboot.model.players.Player;
import springboot.view.gameSetupViews.BoardPositionView;

import java.util.HashSet;
import java.util.Set;

public class BoardPositionController {
    private BoardPositionView view;
    private GameSettingsFacadeController gameSettingsController;

    public BoardPositionController(GameSettingsFacadeController gameSettingsController, BoardController boardControl, int noPlayers, Set<Player> sps) {
        this.gameSettingsController = gameSettingsController;
        this.view = new BoardPositionView(gameSettingsController, this, boardControl, noPlayers, sps);
    }

    public boolean validatePositions(Set<Player> sps) {
        Set<Position> toValidate = new HashSet<>();
        for (Player player : sps){
            toValidate.add(player.getPosition());
        }

        return toValidate.size() == sps.size();
    }



    public void display(){view.setVisible(true);}



}
