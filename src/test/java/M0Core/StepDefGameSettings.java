package M0Core;
import static org.junit.Assert.*;

import game.Complexity;
import game.GameSettings;
import game.RoboRally;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefGameSettings {

    RoboRally game;

    @Given("new game")
    public void new_game() {
        game = RoboRally.getInstance();
        assertNotNull(game);
    }

    @When("select settings")
    public void select_settings() {
        game.newGame(2);
    }

    @Then("game settings has EASY and {int} players")
    public void game_settings_has_easy_and_players(Integer int1) {
        GameSettings set = game.getGameSettings();
        assertEquals(2,set.getAmountOfPlayers());
        assertEquals(Complexity.EASY,set.getComplexity());
    }

}
