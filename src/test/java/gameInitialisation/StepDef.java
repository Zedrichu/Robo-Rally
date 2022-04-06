package gameInitialisation;

import static org.junit.Assert.*;
import game.cards.CardDeck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import view.CardinalPoints;
import view.widgets.Board;
import view.widgets.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class StepDef {

    CardDeck deck;
    Board board;
    @Given("create cardDeck")
    public void create_card_deck() {
        //deck = new CardDeck();
        //assertNotNull(deck);
    }
    @Then("generate board")
    public void generate_board() {
        board = new Board(8, 13);
        assertNotNull(board);
    }
    @Then("view board")
    public void view_board() {
        assertNotNull(board);
    }
}
