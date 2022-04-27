package M1IndependentMove;

import springboot.model.Position;
import springboot.model.players.Player;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import springboot.model.cards.Card;
import springboot.model.cards.CardFactory;
import springboot.model.cards.CardType;
import springboot.model.Direction;
import springboot.model.board.Board;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class StepDef {
    Player player;
    Card card;
    Position newPosition;
    Direction newDirection;
    Board board = new Board(10,10);

    @Given("player {string} at row {int} and column {int} and direction {string}")
    public void player_at_row_and_column_and_direction(String s, int y, int x, String dir) {
        player = new Player(s);
        // x -> column so int2 and y -> row so int1
        player.setPosition(x, y);
        player.setDirection(Direction.getCardinalPointChar(dir));

    }
    @Given("card of type ROTATE and intensity {int}")
    public void card_rotatexclockwise(int x) { card = CardFactory.getCard(CardType.ROTATE, x);}

    @Given("card of type MOVE and intensity {int}")
    public void card_movexforward(int x) {
        card = CardFactory.getCard(CardType.MOVE, x);
    }

    @When("card is played")
    public void card_is_played() {
        player.playCard(card,board);
    }
    @Then("player {string} is at row {int} and column {int} and direction {string}")
    public void player_is_at_row_and_column_and_direction(String s, int ynew, int xnew, String dir) {
        assertTrue(player.getPosition().x == xnew
                && player.getPosition().y == ynew
                && player.getDirection().getAbbr().equals(dir));
    }
}
