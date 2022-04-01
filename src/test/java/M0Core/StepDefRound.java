package M0Core;

import static org.junit.Assert.*;

import game.players.Player;
import game.players.PlayerFactory;
import game.round.Round;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import view.widgets.Board;

import java.util.Set;


public class StepDefRound {
    Set<Player> players;
    Board board = new Board(10,10);
    Round round = Round.getInstance();
    PlayerFactory playerFactory;

    @Given("round counter {int}")
    public void round_counter(int x) {
        round.setRoundNumber(x);
    }
    @Given("set of players <S>")
    public void set_of_players_s() {
        PlayerFactory.getPlayerSet(2);
    }

    //Needs Fixing
    @Given("all in <S> have moved")
    public void all_in_s_have_moved() {

    }

    @When("increment round counter")
    public void increment_round_counter() {
        round.incrementRoundNumber();
    }

    @Then("round counter is {int}")
    public void round_counter_is(int int1) {
        assertEquals(int1, round.getRoundNumber());
    }

    @When("reset round counter")
    public void reset_round_counter() {
        round.resetRound();
        assertEquals(0,round.getRoundNumber());

    }

    @When("play round")
    public void play_round() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("all players have <{int} - round number> cards")
    public void all_players_have_round_number_cards(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
