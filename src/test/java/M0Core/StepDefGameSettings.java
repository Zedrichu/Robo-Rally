package M0Core;
import static org.junit.Assert.*;

import springboot.model.Complexity;
import springboot.model.GameSettings;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefGameSettings {

    GameSettings gameSettings;


    @Given("new game")
    public void new_game() {
        gameSettings = new GameSettings();
    }

    @When("select settings EASY")
    public void select_settings_EASY() {
        gameSettings.setComplexity(Complexity.EASY);
        gameSettings.setAmountOfPlayers(2);
    }

    @When("select settings MEDIUM")
    public void select_settings_MEDIUM() {
        gameSettings.setComplexity(Complexity.MEDIUM);
        gameSettings.setAmountOfPlayers(2);
    }

    @When("select settings HARD")
    public void select_settings_HARD() {
        gameSettings.setComplexity(Complexity.HARD);
        gameSettings.setAmountOfPlayers(2);
    }

    @Then("game settings has EASY and {int} players")
    public void game_settings_has_easy_and_players(Integer int1) {
        assertEquals(2,gameSettings.getAmountOfPlayers());
        assertEquals(Complexity.EASY,gameSettings.getComplexity());
    }
    @Then("game settings has MEDIUM and {int} players")
    public void game_settings_has_medium_and_players(int int1) {
        assertEquals(2,gameSettings.getAmountOfPlayers());
        assertEquals(Complexity.MEDIUM,gameSettings.getComplexity());
    }
    @Then("game settings has HARD and {int} players")
    public void game_settings_has_HARD_and_players(int int1) {
        assertEquals(2,gameSettings.getAmountOfPlayers());
        assertEquals(Complexity.HARD,gameSettings.getComplexity());;
    }
}
