package M0Core;

import static org.junit.Assert.*;

import springboot.model.cards.CardDeck;
import springboot.model.players.Player;
import springboot.model.players.PlayerFactory;
import springboot.model.Round;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class StepDefRound {
    Set<Player> players;
    Round round = new Round(new HashSet<>());
    CardDeck deck = new CardDeck();

    @Given("round counter {int}")
    public void round_counter(int x) {
        round.setRoundNumber(x);
    }
    @Given("set of players <S>")
    public void set_of_players_s() {
        Set<String> names = new HashSet<String>(){{
            add("Adrian");
            add("Jeppe");
        }};
        players = PlayerFactory.getPlayerSet(2,names);
        round.setPlayers(players);
    }

    @Given("all in <S> have moved")
    public void all_in_s_have_moved() {
        for (Player player : players) {

            player.drawCardHand(deck);
            ArrayList<Integer> select = new ArrayList<>();
            for (int i=0;i<9;i++) select.add(i);
            player.chooseCards(5-round.getRoundNumber(), select, deck);
        }
        round.setPlayers(players);
        assertTrue(round.haveAllPlayed());
    }

    @Given("not all in <S> have moved")
    public void not_all_in_s_have_moved() {
        for (Player player : players) {

            player.drawCardHand(deck);
            ArrayList<Integer> select = new ArrayList<>();
            for (int i=0;i<9;i++) select.add(i);
            player.chooseCards(5-round.getRoundNumber()+1, select, deck);
        }
        round.setPlayers(players);
        assertFalse(round.haveAllPlayed());
    }
    @Given("any in <S> don't have any cards")
    public void any_in_s_don_t_have_any_cards() {
        for (Player player : players) {
            player.drawCardHand(deck);
            //unsure if this is the correct way to do this
            ArrayList<Integer> select = new ArrayList<>();
            for (int i=0;i<9;i++) select.add(i);
            player.chooseCards(0, select, deck);
        }
        round.setPlayers(players);
        assertTrue(round.checkNoCardsInHand());
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

    @When("draw cards for each player")
    public void draw_cards_for_each_player() {
        for (Player player : players) {
            player.drawCardHand(new CardDeck());
        }
    }

    @Then("each player have a card hand with {int} cards")
    public void each_player_have_a_card_hand_with_cards(Integer int1) {
        for (Player player : players) {
            assertEquals(9, player.getHandSize());
        }
    }
}
