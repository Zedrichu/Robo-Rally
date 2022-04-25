package springboot.controller;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.controller.gameSetup.PlayerSetupController;
import springboot.controller.gameplay.GameController;
import springboot.model.Complexity;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.CardDeck;
import springboot.model.players.Player;

import java.util.Set;

public class ApplicationController {

    private GameSettingsFacadeController settingsController;
    private CardController cardController;
    private PlayerSetupController playerSetupController;
    private GameController gameController;

    public void game(GameSettings gameSettings, Board board, CardDeck deck) {
        gameController = new GameController(this, gameSettings, board, deck);
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
