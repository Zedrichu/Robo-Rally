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
import view.widgets.Board;

public class StepDef {
    Player player;
    Card card;
    Position newPosition;
    Direction newDirection;
    Board board = new Board(10,10,1);
    @Given("player {string} at row {int} and column {int} and direction {string}")
    public void player_at_row_and_column_and_direction(String string, Integer int1, Integer int2,String chr) {
        player = new Player(string);
        // x -> column so int2 and y -> row so int1
        player.setPosition(int2, int1);
        player.setDirection(Direction.getCardinalPointChar(chr));
    }
    @Given("card of type ROTATE and intensity {int}")
    public void card_rotatexclockwise(int x) { card = CardFactory.getCard(CardType.ROTATE, x);}

    @Given("card of type MOVE and intensity {int}")
    public void card_movexforward(int x) {
        card = CardFactory.getCard(CardType.MOVE, x);
    }

    @When("card is played")
    public void card_is_played() {
        Object[] newPosDir = card.applyAction(player.getPosition(), player.getDirection());
        newPosition = (Position) newPosDir[0];
        newDirection = (Direction) newPosDir[1];
        if (board.checkPositionInBounds(newPosition)) {
            player.setDirection(newDirection);
            player.setPosition(newPosition);
        }
    }
    @Then("player {string} is at row {int} and column {int} and direction {string}")
    public void player_is_at_row_and_column_and_direction_e(String string, Integer int1, Integer int2, String string2) {
        assertTrue(player.getPosition().x == int2
                && player.getPosition().y == int1
                && player.getDirection().getAbbr().equals(string2));
    }

}
