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

import java.util.Set;


public class StepDef {
    Set<Player> players;
    Board board = new Board(10,10);
    Round round = Round.getInstance();
    PlayerFactory playerFactory = new PlayerFactory();

    @Given("round counter {int}")
    public void round_counter(Integer int1) {
        round.setRoundNumber(int1);
        round.setBoard(board);
    }
    @Given("set of players <S>")
    public void set_of_players_s() {
        PlayerFactory.getPlayerSet(2);
    }

    @Given("all in <S> have moved")
    public void all_in_s_have_moved() {

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
