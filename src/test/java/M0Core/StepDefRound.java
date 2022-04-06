package M0Core;

import static org.junit.Assert.*;

import game.cards.CardDeck;
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
        players = PlayerFactory.getPlayerSet(2);
        round.setPlayers(players);
    }

    @Given("all in <S> have moved")
    public void all_in_s_have_moved() {
        for (Player player : players) {
            player.drawCardHand(CardDeck.getInstance());
            player.chooseCards(5-round.getRoundNumber());
            System.out.println("Player gets some cards");
        }
        round.setPlayers(players);
        assertTrue(round.haveAllPlayed());
    }

    @Given("not all in <S> have moved")
    public void not_all_in_s_have_moved() {
        int i=0;
        for (Player player : players) {
            player.drawCardHand(CardDeck.getInstance());
            player.chooseCards(5-round.getRoundNumber()+1);
            System.out.println("Not all players have moved");
        }
        round.setPlayers(players);
        assertFalse(round.haveAllPlayed());
    }

    @When("increment round counter")
    public void increment_round_counter() {
        if (round.haveAllPlayed()) round.incrementRoundNumber();
    }

    @Then("round counter is {int}")
    public void round_counter_is(int int1) {
        assertEquals(int1, round.getRoundNumber());
    }

    @When("reset round counter")
    public void reset_round_counter() {
        if (round.getRoundNumber()==5 && round.haveAllPlayed()) round.resetRound();
        assertEquals(1,round.getRoundNumber());

    }



}
