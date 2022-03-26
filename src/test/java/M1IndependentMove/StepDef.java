package M1IndependentMove;

import game.Position;
import game.cards.*;
import game.players.Player;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import view.CardinalPoints;

public class StepDef {
    Player player;
    Card card;
    Position newPosition;
    CardinalPoints newDirection;
    @Given("player {string} at row {int} and column {int} and direction {string}")
    public void player_at_row_and_column_and_direction(String string, Integer int1, Integer int2,String chr) {
        player = new Player(string);
        player.setPosition(int1, int2);
        player.setDirection(CardinalPoints.getCardinalPointChar(chr));
    }
    @Given("card of type MOVE and intensity {int}")
    public void card_movexforward(int x) {
        card = CardFactory.getCard(CardType.MOVE, x);
    }
    @When("card is played")
    public void card_is_played() {
        Object[] newPosDir = card.applyAction(player.getPosition(), player.getDirection());
        newPosition = (Position) newPosDir[0];
        newDirection = (CardinalPoints) newPosDir[1];
        player.setDirection(newDirection);
        player.setPosition(newPosition);
    }
    @Then("player {string} is at row {int} and column {int} and direction {string}")
    public void player_is_at_row_and_column_and_direction_e(String string, Integer int1, Integer int2, String string2) {
        assertTrue(player.getPosition().x == int2
                && player.getPosition().y == int1
                && player.getDirection().getAbbr().equals(string2));
    }

}
