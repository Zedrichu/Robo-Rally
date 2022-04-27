package M0Core;
import static org.junit.Assert.*;

import io.cucumber.java.bs.A;
import springboot.controller.ApplicationController;
import springboot.model.Complexity;
import springboot.model.GameSettings;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import springboot.controller.gameSetup.GameSettingsFacadeController;

public class StepDefGameSettings {

    ApplicationController applicationController = new ApplicationController();
    GameSettingsFacadeController gameSettingsController;

    @Given("new game")
    public void new_game() {
        gameSettingsController = new GameSettingsFacadeController(applicationController);
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
