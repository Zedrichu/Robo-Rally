package springboot.controller;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.model.GameSettings;
import springboot.model.cards.CardDeck;
import java.beans.PropertyChangeSupport;

public class ApplicationController {

    private GameSettingsFacadeController settingsController;
    private GameController gameController;

    public void game(PropertyChangeSupport support, BoardController boardController, GameSettings gameSettings, CardDeck deck) {
        gameController = new GameController(this, gameSettings, boardController.getBoard(), deck, support);
        gameController.display();
    }

    public void settings() {
        settingsController = new GameSettingsFacadeController(this);
        settingsController.display();
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.settings();
    }

}
