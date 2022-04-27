package M0Core;
import static org.junit.Assert.*;

import springboot.controller.ApplicationController;
import springboot.model.Complexity;
import springboot.model.GameSettings;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import springboot.controller.gameSetup.GameSettingsFacadeController;

import java.beans.PropertyChangeSupport;

public class StepDefGameSettings {

    GameSettings gameSettings;


    @Given("new game")
    public void new_game() {
        gameSettings = new GameSettings(new PropertyChangeSupport(this));
    }

    @When("select settings")
    public void select_settings() {
        gameSettings.setComplexity(Complexity.EASY);
        gameSettings.setAmountOfPlayers(2);
    }

    @Then("game settings has EASY and {int} players")
    public void game_settings_has_easy_and_players(Integer int1) {
        assertEquals(2,gameSettings.getAmountOfPlayers());
        assertEquals(Complexity.EASY,gameSettings.getComplexity());
    }
    @Then("game settings has MEDIUM and {int} players")
    public void game_settings_has_medium_and_players(int int1) {
        GameSettings set = gameSettingsController.getGameSettings();
        assertEquals(int1, set.getAmountOfPlayers());
        assertEquals(Complexity.MEDIUM,set.getComplexity());
    }
    @Then("game settings has HARD and {int} players")
    public void game_settings_has_HARD_and_players(int int1) {
        GameSettings set = gameSettingsController.getGameSettings();
        assertEquals(int1,set.getAmountOfPlayers());
        assertEquals(Complexity.HARD,set.getComplexity());
    }
}
