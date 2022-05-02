package springboot.controller;

import springboot.controller.game.BoardController;
import springboot.controller.game.GameController;
import springboot.controller.setup.GameSettingsController;
import springboot.model.GameSettings;
import springboot.model.cards.CardDeck;

/**
 * Facade controller class denoting the entry point in the RoboRally application.
 * Triggers the settings interface upon start up and links the 2 facade controllers together.
 * @author Adrian Zvizdenco & Jeppe Mikkelsen
 */
public class ApplicationController {

    private GameSettingsController settingsController;
    private GameController gameController;

    /** Method to start the playable game interface after the settings have been established.
     *
     * @param boardController - BoardController used for generating boards and passing them to the game.
     * @param gameSettings - GameSettings objected containing the complexity and number of players
     * @param deck - CardDeck object from which the cards for each player would be drawn (unique in game).
     */
    public void game(BoardController boardController, GameSettings gameSettings, CardDeck deck) {
        gameController = new GameController(gameSettings, boardController.getBoard(), deck);
        gameController.display();
    }

    /** Method to trigger the settings interface where the user sets up the game to be played.
     */
    public void settings() {
        settingsController = new GameSettingsController(this);
        settingsController.display();
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.settings();
    }

}
