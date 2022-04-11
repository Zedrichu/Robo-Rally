package M0Core;

import static org.junit.Assert.*;

import game.GameSettings;
import game.RoboRally;
import game.cards.CardDeck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDefGameInitialise {

    RoboRally robotrally = RoboRally.getInstance();
    GameSettings gameSettings;
    CardDeck deck = CardDeck.getInstance();


    @Given("game settings")
    public void game_settings() {
        assertNotNull(robotrally);
    }

    @Given("cardDeck")
    public void card_deck() {
        deck = CardDeck.getInstance();
        assertNotNull(deck);

    }

    //TODO
    @Then("place players on starting tiles")
    public void place_players_on_starting_tiles() {



    }
}
