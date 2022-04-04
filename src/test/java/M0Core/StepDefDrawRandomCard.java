package M0Core;

import game.cards.CardDeck;
import game.players.Player;
import game.players.PlayerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class StepDefDrawRandomCard {
    Player player;
    CardDeck deck;


    @Given("player {string}")
    public void player(String string) {
        player = PlayerFactory.getPlayer(string);
    }
    @Given("card deck")
    public void card_deck() {
        deck = CardDeck.getInstance();
        assertNotNull(deck);
    }
    @When("draw cards")
    public void draw_cards() {
        player.drawCardHand(deck);
    }
    @Then("player {string} has card hand with {int} cards")
    public void player_has_set_of_cards_with_cards(String string, Integer int1) {
        assertEquals(9,player.getHandSize());
    }

    @Given("card hand of player {string} with {int} cards")
    public void card_hand_of_player_with_cards(String string, Integer int1) {
        player.drawCardHand(deck);
        assertEquals(9,player.getHandSize());
    }

    @When("choose {int} cards")
    public void choose_cards(Integer int1) {
        //player.chooseCards(5);
    }

}
