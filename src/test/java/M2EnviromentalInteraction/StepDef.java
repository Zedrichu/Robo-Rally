package M2EnviromentalInteraction;


import static org.junit.Assert.*;
import game.cards.CardHand;
import game.players.Player;
import game.round.Round;
import game.cards.*;
import io.cucumber.java.en.And;
import view.CardinalPoints;
import view.TileType;
import view.widgets.Board;
import view.widgets.Tile;
import view.widgets.Board;

import java.util.ArrayList;
import java.util.LinkedList;


import game.Position;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

    TileType type;
    Position newPosition;
    Player player;
    Board board;
    Tile tile;
    Round round;
    Card card = CardFactory.getCard(CardType.MOVE, 2);
    CardinalPoints newDir;
    CardDeck deck = CardDeck.getInstance();
    //CardHand hand;


    // Player with amount of lives
    @Given("Player {string} at row {int} column {int} with {int} lives")
    public void player_at_row_column_with_lives(String s, int x, int y, int z) {
        player = new Player(s);
        player.setPosition(x, y);
        player.setLives(z);
    }

    // Player with direction
    @Given("Player {string} on row {int} column {int} and direction {string}")
    public void player_on_row_column_and_direction(String s, int x, int y, String dir) {
        player = new Player(s);
        player.setPosition(x, y);
        player.setDirection(CardinalPoints.getCardinalPointChar(dir));
    }

    // Player with cardHand
    @Given("player {string} at row {int} column {int} with CardHand")
    public void player_at_row_column_with_card_hand(String s, int x, int y) {
        player = new Player(s);
        player.setPosition(x, y);
        player.drawCardHand(deck);
    }

    // acidTile
    @Given("acidTile {string} at row {int} and column {int}")
    public void acid_tile_at_row_and_column(String s, int x, int y) {
        type = TileType.ACID;
        tile = new Tile(type);
        tile.position = new Position(x, y);
    }
    // laserTile
    @Given("laserTile {string} at row {int}  and column {int}")
    public void laser_tile_at_row_and_column(String s, int x, int y) {
        type = TileType.RADIATION;
        tile = new Tile(type);
        tile.position = new Position(x, y);
    }
    // lifeToken
    @Given("lifeToken {string} at row {int}  and column {int}")
    public void life_token_at_row_and_column(String s, int x, int y) {
        type = TileType.LIFETOKEN;
        tile = new Tile(type);
        tile.position = new Position(x, y);
    }
    // conveyorBelt
    @Given("conveyorBelt {string} is on row {int} column {int} with direction {string}")
    public void conveyor_belt_is_on_row_column_with_direction(String s, int x, int y, String convDir) {
        type = TileType.CONVEYORBELT;
        tile = new Tile(type);
        tile.position = new Position(x, y);
        tile.setDirection(CardinalPoints.getCardinalPointChar(convDir));
    }

    //pitTile
    @Given("pitTile {string} at row {int} and column {int}")
    public void pit_tile_at_row_and_column(String s, int x, int y) {
        type = TileType.PIT;
        tile = new Tile(type);
        tile.position = new Position(x,y);

    }

    @When("round is incremented")
    public void round_is_incremented() {
        round = new Round();
        round.setRoundNumber(1);
        //System.out.println(round.getRoundNumber());
        round.incrementRoundNumber();
    }

    @Then("player {string} has {int} add {int} lives which leaves them at {int} lives")
    public void player_has_lives(String string, int lives, int damage, int newlives) {
        player.updateLives(damage);
        assertTrue(player.getLives() == newlives);
    }

    @Then("Player {string} on row {int}  new column {int} and direction {string}")
    public void player_on_row_new_column_and_direction(String s, int xnew, int ynew, String dir) {
        Object[] newPosDir = card.applyAction(player.getPosition(), player.getDirection());
        newPosition = (Position) newPosDir[0];
        newDir = (CardinalPoints) newPosDir[1];

        player.setPosition(newPosition);
        player.setDirection(newDir);


        assertTrue(player.getPosition().x == xnew &&
                player.getPosition().y == ynew &&
                player.getDirection().getAbbr().equals(dir));
    }
    //pitTile
    @Then("player {string} with new CardHand")
    public void player_with_new_card_hand(String s){

        player.skipCard(round.getRoundNumber());

        assertNull(player.hand.getHand().get(round.getRoundNumber()));


    }


}

