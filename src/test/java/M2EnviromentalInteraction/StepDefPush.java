package M2EnviromentalInteraction;

import springboot.model.players.Player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import springboot.model.Direction;
import springboot.model.Position;
import springboot.model.cards.Card;
import springboot.model.cards.CardFactory;
import springboot.model.cards.CardType;
import view.widgets.Board;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StepDefPush {

    Player player1;
    Player player2;
    Card card;
    private CardType type;
    Position newPosition;
    Direction newDirection;
    
    Board board = new Board(10,10,1);

    @Given("A player1 {string} at row {int} column {int} with direction {string}")
    public void a_player1_at_row_y1_column_with_direction(String s1, int x1, int y1, String dir1) {
        player1 = new Player(s1);
        player1.setPosition(y1, x1);
        player1.setDirection(Direction.getCardinalPointChar(dir1));
    }
    @Given("A player2 {string} at row {int} column {int} with direction {string}")
    public void a_player2_at_row_column_with_direction(String s2, int x2, int y2, String dir2) {
        player2 = new Player(s2);
        player2.setPosition(y2, x2);
        player2.setDirection(Direction.getCardinalPointChar(dir2));
    }
    @Given("A player1 {string} has a MoveCard with intensity {int}")
    public void a_player1_has_a_move_card_with_intensity(String s1, int intensity) {
        card = CardFactory.getCard(type.MOVE, intensity);
    }
    @When("player1 {string} plays MoveCard")
    public void player1_plays_move_card(String s1) {

        Object[] newPosDir = card.applyAction(player1.getPosition(), player1.getDirection());
        newPosition = (Position) newPosDir[0];
        newDirection = (Direction) newPosDir[1];
        if (board.checkPositionInBounds(newPosition)) {
            player1.setDirection(newDirection);
            player1.setPosition(newPosition);
        }
    }

    @Then("player1 {string} is at row {int} column {int} with direction {string}")
    public void player1_is_at_row_column_with_direction(String s1, int y2, int x2, String dir1) {
    assertTrue(player1.getPosition().x == x2
            && player1.getPosition().y == y2
            && player1.getDirection().getAbbr().equals(dir1));
    }

    @Then("player2 {string} is pushed in direction {string} to new location at row {int} column {int} with direction {string}")
    public void player2_is_pushed_in_direction_to_new_location_at_row_column_with_direction(String s2, String dir1, int y3, int x3, String dir2) {
        player1.pushPlayer(player2);

        assertTrue(player2.getPosition().x == x3
                && player2.getPosition().y == y3
                && player2.getDirection().getAbbr().equals(dir2));
    }
}
