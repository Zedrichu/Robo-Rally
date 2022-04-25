package M2EnviromentalInteraction;


import static org.junit.Assert.*;

import springboot.model.players.Player;
import springboot.model.round.Round;
import springboot.model.cards.CardDeck;
import springboot.model.Direction;
import springboot.model.checkPoints.CheckPoint;
import springboot.model.checkPoints.CheckPointSet;
import springboot.model.obstacles.*;
import springboot.model.tiles.TileType;
import springboot.model.board.Board;
import springboot.model.board.Tile;


import springboot.model.Position;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefObstacle {

    TileType type;
    Player player;
    Tile tile;
    Round round= new Round();
    CardDeck deck = new CardDeck();
    private Obstacle<Player, Integer> o;
    CheckPoint cp = new CheckPoint();
    CheckPointSet TotalCPSet;
    Board board = new Board(10,10);
    private int size = 0;

    // Player with amount of lives
    @Given("Player {string} at row {int} column {int} with {int} lives")
    public void player_at_row_column_with_lives(String s, int x, int y, int z) {
        player = new Player(s);
        board.loadBoard(3);
        player.setPosition(x, y);
        player.setLives(z);
    }

    // Player with direction
    @Given("Player {string} on row {int} column {int} and direction {string}")
    public void player_on_row_column_and_direction(String s, int x, int y, String dir) {
        player = new Player(s);
        player.setPosition(x, y);
        player.setDirection(Direction.getCardinalPointChar(dir));
        board.loadBoard(3);
    }
    // Player with cardHand
    @Given("player {string} at row {int} column {int} with CardHand")
    public void player_at_row_column_with_card_hand(String s, int x, int y) {
        player = new Player(s);
        player.setPosition(x, y);
        player.drawCardHand(deck);
        board.loadBoard(3);
    }

    // acidTile
    @Given("acidTile {string} at row {int} and column {int}")
    public void acid_tile_at_row_and_column(String s, int x, int y) {
        o = new Acid();
        type = TileType.ACID;
        tile = new Tile(type);
        tile.position = new Position(x, y);

    }
    // laserTile
    @Given("laserTile {string} at row {int}  and column {int}")
    public void laser_tile_at_row_and_column(String s, int x, int y) {
        o = new Laser();
        type = TileType.RADIATION;
        tile = new Tile(type);
        tile.position = new Position(x, y);
    }
    // lifeToken
    @Given("lifeToken {string} at row {int}  and column {int}")
    public void life_token_at_row_and_column(String s, int x, int y) {
        o = new LifeToken();
        type = TileType.LIFETOKEN;
        tile = new Tile(type);
        tile.position = new Position(x, y);
    }
    // conveyorBelt
    @Given("conveyorBelt {string} is on row {int} column {int} with direction {string}")
    public void conveyor_belt_is_on_row_column_with_direction(String s, int x, int y, String convDir) {
        o = new ConveyorBelt();
        type = TileType.CONVEYORBELT;
        tile = new Tile(type);
        tile.position = new Position(x, y);
        tile.setDirection(Direction.getCardinalPointChar(convDir));
    }

    //pitTile
    @Given("pitTile {string} at row {int} and column {int}")
    public void pit_tile_at_row_and_column(String s, int x, int y) {
        o = new Pit();
        type = TileType.PIT;
        tile = new Tile(type);
        tile.position = new Position(x,y);

    }
    @Given("player {string} on row {int} and column {int} with set of visited CheckPoints including Checkpoint {int}")
    public void player_on_row_and_column_with_set_of_visited_check_points_including_checkpoint(String s, int x, int y, int cpID) {
        player = new Player(s);
        player.setPosition(x, y);
        player.addCheckPoint(cp);
        //System.out.print("in given " + player.getCpSet());
        this.size = player.getCollectedCP().size();
        board.loadBoard(3);

    }
    // visiting new CheckPoint
    @Given("player {string} on row {int} and column {int} with set of visited CheckPoints")
    public void player_on_row_and_column_with_set_of_visited_check_points(String s, int x, int y) {
        player = new Player(s);
        player.setPosition(x, y);
    }
    // CheckPoint tile
    @Given("CheckPoint {string} on row {int} and column {int} with ID {int}")
    public void check_point_on_row_and_column_with_id(String s, int x, int y, int cpID) {
        cp.setPosition(x,y);
        type = TileType.CHECKPOINT;
        tile = new Tile(type);//
        tile.position = new Position(x,y);

    }

    @Given("full set of CheckPoints from board of size {int}")
    public void full_set_of_check_points_from_board_of_size(int size)  {
        TotalCPSet = new CheckPointSet(size);
    }

    @When("round is incremented")
    public void round_is_incremented() {
        round.setRoundNumber(1);
        round.incrementRoundNumber();
    }

    @Then("player {string} has  {int} lives")
    public void player_has_lives(String s, int newlives) {
        o.applyDamage(player, null);

        assertEquals(player.getLives(), newlives, 0.0);
    }

    @Then("Player {string} on row {int}  new column {int} and direction {string}")
    public void player_on_row_new_column_and_direction(String s, int xnew, int ynew, String dir) {
        o.applyDamage(player, null);

        assertTrue(player.getPosition().x == xnew &&
                player.getPosition().y == ynew &&
                player.getDirection().getAbbr().equals(dir));
    }
    //pitTile
    @Then("player {string} with new CardHand")
    public void player_with_new_card_hand(String s){
        int r = round.getRoundNumber();
        o.applyDamage(player, r);
        assertNull(player.hand.getHand().get(round.getRoundNumber()));
    }
    
    // collecting CheckPoints
    @Then("player {string} has new set of visited CheckPoints")
    public void player_has_new_set_of_visited_check_points(String s) {
        player.addCheckPoint(cp);
        assertTrue(player.getCollectedCP().contains(cp));
    }
    // player has collected all CheckPoints = WINS
    @Then("if player {string} has complete set of CheckPoints then player wins")
    public void if_player_has_complete_set_of_check_points_then_player_wins(String s) {
        player.hasAllCP(board.getCheckPoints());
    }

    // player visits a CheckPoint which has previously been visited
    @Then("player {string} has same set of CheckPoints as before")
    public void player_has_same_set_of_check_points_as_before(String s) {
        assertTrue(player.getCollectedCP().contains(cp));
        assertEquals(size,player.getCollectedCP().size());
    }
}


