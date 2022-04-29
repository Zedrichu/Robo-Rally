package springboot.controller;

import springboot.controller.game.BoardController;
import springboot.controller.game.GameController;
import springboot.controller.setup.GameSettingsFacadeController;
import springboot.model.GameSettings;
import springboot.model.cards.CardDeck;

public class ApplicationController {

    private GameSettingsFacadeController settingsController;
    private GameController gameController;

    public void game(BoardController boardController, GameSettings gameSettings, CardDeck deck) {
        gameController = new GameController(gameSettings, boardController.getBoard(), deck);
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
