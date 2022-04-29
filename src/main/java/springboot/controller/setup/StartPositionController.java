package springboot.controller.setup;


import springboot.controller.game.BoardController;
import springboot.model.Position;
import springboot.model.players.Player;
import springboot.view.setupInterfaces.StartPositionView;

import java.util.HashSet;
import java.util.Set;

public class StartPositionController {
    private StartPositionView view;
    private GameSettingsFacadeController gameSettingsController;

    public StartPositionController(GameSettingsFacadeController gameSettingsController, BoardController boardControl, int noPlayers, Set<Player> sps) {
        this.gameSettingsController = gameSettingsController;
        this.view = new StartPositionView(gameSettingsController, this, boardControl, noPlayers, sps);
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
