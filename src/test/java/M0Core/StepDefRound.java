package M0Core;

import static org.junit.Assert.*;

import springboot.model.cards.CardDeck;
import game.players.Player;
import springboot.model.players.PlayerFactory;
import game.round.Round;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Set;


public class StepDefRound {
    Set<Player> players;
    Round round = Round.getInstance();

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

            player.drawCardHand(new CardDeck());
            player.chooseCards(5-round.getRoundNumber());
        }
        round.setPlayers(players);
        assertTrue(round.haveAllPlayed());
    }

    @Given("not all in <S> have moved")
    public void not_all_in_s_have_moved() {
        for (Player player : players) {

            player.drawCardHand(new CardDeck());
            player.chooseCards(5-round.getRoundNumber()+1);
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
    //TODO
    @Given("any in <S> don't have any cards")
    public void any_in_s_don_t_have_any_cards() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("all players have a card hand with {int} cards")
    public void all_players_have_a_card_hand_with_cards(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
