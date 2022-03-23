package M1IndependentMove;

import game.players.Player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import view.CardinalPoints;

public class StepDef {
    Player player;
    @Given("player {string}  at row {int} and column {int} and direction {string}")
    public void player_at_row_and_column_and_direction(String string, Integer int1, Integer int2,String chr) {
        player = new Player(string);
        player.setPosition(int1, int2);
        player.setDirection(CardinalPoints.getCardinalPointChar(chr));
    }
    @Given("card Move1Forward")
    public void card_move1forward() {
        throw new io.cucumber.java.PendingException();
    }
    @When("card is played")
    public void card_is_played() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("player {string} is at row {int} and column {int} and direction E")
    public void player_is_at_row_and_column_and_direction_e(String string, Integer int1, Integer int2) {

    }

}
