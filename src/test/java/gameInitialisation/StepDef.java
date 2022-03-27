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
        int initialRow = 2;
        int initialColumn = 2;
        CardinalPoints currentDirection = CardinalPoints.N;

        board.setRobot(initialRow, initialColumn, currentDirection);

        ControlPanel control = new ControlPanel(board, initialRow, initialColumn, currentDirection);

        JFrame f = new JFrame("game.RoboRally Demo - v.0.1");
        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.add(board);
        f.add(control);
        f.setSize(900, 700);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        assertNotNull(f.getComponents());
    }
}
