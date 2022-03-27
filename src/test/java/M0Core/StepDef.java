package M0Core;

import static org.junit.Assert.*;

import game.GameSettings;
import game.players.Player;
import game.players.PlayerFactory;
import game.round.Round;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import view.widgets.Board;
import game.round.*;


public class StepDef {
    Player[] players;
    Board board;
    Round round = new Round(players, board);
    PlayerFactory playerFactory = new PlayerFactory();

    @Given("round counter {int}")
    public void round_counter(Integer int1) {
        round.setRoundNumber(int1);
    }
    @Given("set of players <S>")
    public void set_of_players_s() {
        PlayerFactory.getPlayerSet(2);
    }

    @Given("all in <S> have moved")
    public void all_in_s_have_moved() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("increment round counter")
    public void increment_round_counter() {
        round.incrementRoundNumber();
    }
    @Then("round counter is {int}")
    public void round_counter_is(Integer int1) {
        round.getRoundNumber();
    }
}
