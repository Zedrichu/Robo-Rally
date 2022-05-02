package springboot.controller.setup;

import springboot.controller.game.BoardController;
import springboot.model.Position;
import springboot.model.players.Player;
import springboot.view.setupInterfaces.StartPositionView;

import java.util.HashSet;
import java.util.Set;

/**
 * Controller class defining the functionalities in selecting the starting position for each player in the game.
 * @author Adrian Zvizdenco & Jeppe Mikkelsen
 */
public class StartPositionController {
    private final StartPositionView view; // Link to corresponding view

    /**
     * Constructor of StartPositionController, defining the corresponding view to be controlled.
     * @param gameSettingsController - Link to the facade settings controller, used for application flow.
     * @param boardControl - Link to the board controller, defining the starting positions available and marking robots on it.
     * @param noPlayers - Positive integer, defining the number of players playing the game, based on GameSettings.
     * @param sps - Set of players registered currently in the game (field in Round).
     */
    public StartPositionController(GameSettingsController gameSettingsController, BoardController boardControl, int noPlayers, Set<Player> sps) {
        this.view = new StartPositionView(gameSettingsController, this, boardControl, noPlayers, sps);
    }

    /**
     * Method to validate the positions selected in the view combo boxes.
     * @param sps - Set of players registered in the game
     * @return boolean value, true if all players have selected positions, false - otherwise.
     */
    public boolean validatePositions(Set<Player> sps) {
        Set<Position> toValidate = new HashSet<>();
        for (Player player : sps){
            toValidate.add(player.getPosition());
        }

        return toValidate.size() == sps.size();
    }

    /**
     * Method to make the corresponding view of the controller visible.
     */
    public void display(){view.setVisible(true);}
}
