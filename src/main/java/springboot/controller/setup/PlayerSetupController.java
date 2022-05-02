package springboot.controller.setup;

import springboot.view.setupInterfaces.PlayerSetupView;

import java.util.Set;

/**
 * Controller class handling the selection of player-related settings.
 * @author Adrian Zvizdenco & Jeppe Mikkelsen
 */
public class PlayerSetupController {
    private final PlayerSetupView view; //Link to corresponding view

    /**
     * Class constructor creating the view to be controlled
     * @param gameSettingsController - Link to the facade settings controller, used for application flow.
     * @param noPlayers - Positive integer, defining the number of players in the game.
     */
    public PlayerSetupController(GameSettingsController gameSettingsController, int noPlayers){
        this.view = new PlayerSetupView(gameSettingsController, this, noPlayers);
    }

    /**
     * Method that validates the player names to be distinct
     * @param names - Set of strings holding player names.
     * @param noPlayers - Positive integer, defining the number of players in the game.
     */
    public boolean validateNames(Set<String> names, int noPlayers){
        return names.size() == noPlayers;
    }

    /**
     * Method to make the corresponding view of the controller visible.
     */
    public void display(){view.setVisible(true);}
}
