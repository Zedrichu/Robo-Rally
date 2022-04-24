package M0Core;
import static org.junit.Assert.*;

import game.Complexity;
import game.GameSettings;
import game.RoboRally;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import springboot.controller.ApplicationController;
import springboot.controller.GameSettingsController;

public class StepDefGameSettings {

    GameSettingsController gameSettingsController;

    @Given("new game")
    public void new_game() {
        gameSettingsController = new GameSettingsController(new ApplicationController());
        assertNotNull(gameSettingsController);
    }

    @When("select settings")
    public void select_settings() {
        gameSettingsController.setGameSettings(Complexity.EASY, 2);
    }

    @Then("game settings has EASY and {int} players")
    public void game_settings_has_easy_and_players(Integer int1) {
        GameSettings set = gameSettingsController.getGameSettings();
        assertEquals(2,set.getAmountOfPlayers());
        assertEquals(Complexity.EASY,set.getComplexity());
    }

}
