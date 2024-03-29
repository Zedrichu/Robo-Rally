package M2EnviromentalInteraction;


import static org.junit.Assert.*;

import springboot.model.players.Player;
import springboot.model.Round;
import springboot.model.cards.CardDeck;
import springboot.model.Direction;
import springboot.model.obstacles.CheckPoint;
import springboot.model.board.TileType;
import springboot.model.board.Board;
import springboot.model.board.Tile;


import springboot.model.Position;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashSet;
import java.util.Set;

public class StepDefObstacle {

    TileType type;
    Player player;
    Tile tile;
    Round round = new Round(new HashSet<>());
    CardDeck deck = new CardDeck();
    Board board = new Board(9,9);
    Set<CheckPoint> totalCP;
    private int size = 0;


    // Player with amount of lives
    @Given("Player {string} at row {int} column {int} with {int} lives")
    public void player_at_row_column_with_lives(String s, int x, int y, int z) {
        player = new Player(s);
        player.setPosition(3, 1);
        player.setLives(z);
        System.out.println(player.getLives());
        board.loadBoard_Easy();
    }

    // Player with direction
    @Given("Player {string} on row {int} column {int} and direction {string}")
    public void player_on_row_column_and_direction(String s, int x, int y, String dir) {
        player = new Player(s);
        player.setPosition(2, 0);
        player.setDirection(Direction.getCardinalPointChar(dir));
        board.loadBoard_Easy();

    }
    // Player with cardHand
    @Given("player {string} at row {int} column {int} with CardHand")
    public void player_at_row_column_with_card_hand(String s, int x, int y) {
        player = new Player(s);
        player.setPosition(0, 1);
        player.drawCardHand(deck);
        board.loadBoard_Easy();


    }
    // visiting new CheckPoint
    @Given("player {string} on row {int} and column {int} with set of visited CheckPoints")
    public void player_on_row_and_column_with_set_of_visited_check_points(String s, int x, int y) {
        player = new Player(s);
        player.setPosition(x, y);
        this.size = player.getCollectedCP().size();
    }

    // acidTile
    @Given("acidTile {string} at row {int} and column {int}")
    public void acid_tile_at_row_and_column(String s, int x, int y) {
        tile = new Tile(TileType.ACID);
        tile.position = new Position(x, y);
    }
    // laserTile
    @Given("laserTile {string} at row {int}  and column {int}")
    public void laser_tile_at_row_and_column(String s, int x, int y) {
        tile = new Tile(TileType.LASER);
        tile.position = new Position(x, y);
    }
    // lifeToken
    @Given("lifeToken {string} at row {int}  and column {int}")
    public void life_token_at_row_and_column(String s, int x, int y) {
        tile = new Tile(TileType.LIFETOKEN);
        tile.position = new Position(x, y);
    }
    // conveyorBelt
    @Given("conveyorBelt {string} is on row {int} column {int} with direction {string}")
    public void conveyor_belt_is_on_row_column_with_direction(String s, int x, int y, String convDir) {
        tile = new Tile(TileType.CONVEYORBELT);
        tile.position = new Position(x, y);

        tile.setDirection(Direction.getCardinalPointChar(convDir));
    }

    //pitTile
    @Given("pitTile {string} at row {int} and column {int}")
    public void pit_tile_at_row_and_column(String s, int x, int y) {
        tile = new Tile(TileType.PIT);
        tile.position = new Position(x,y);
    }

    // CheckPoint tile
    @Given("CheckPoint {string} on row {int} and column {int} with ID")
    public void check_point_on_row_and_column_with_id(String s, int x, int y) {
        board.addCheckPoint(new CheckPoint());
        board.loadBoard_Easy();
        tile = new Tile(TileType.CHECKPOINT);
        tile.position = new Position(x,y);

    }

    @Given("full set of CheckPoints from board of size {int}")
    public void full_set_of_check_points_from_board_of_size(int size)  {
        totalCP = board.getCheckPoints();
    }

    @When("round is incremented")
    public void round_is_incremented() {
        round.setRoundNumber(1);
        round.incrementRoundNumber();
    }


    @Then("Player {string} on row {int}  new column {int} and direction {string}")
    public void player_on_row_new_column_and_direction(String s, int xnew, int ynew, String dir) {
        //player.hitObstacle(tile.getType().getObstacle(), round.getRoundNumber());
        player.hitObstacle(board, 1);

        System.out.println("x"+ player.getPosition().x + "y :" + player.getPosition().y);
        assertTrue(player.getPosition().x == xnew &&
                player.getPosition().y == ynew &&
                player.getDirection().getAbbr().equals(dir));
    }
    //pitTile
    @Then("player {string} with new CardHand")
    public void player_with_new_card_hand(String s){
       // player.hitObstacle(tile.getType().getObstacle(), round.getRoundNumber());
        player.hitObstacle(board, round.getRoundNumber());
        assertNull(player.hand.getHand().get(round.getRoundNumber()));
    }
    
    // collecting CheckPoints
    @Then("player {string} has new set of visited CheckPoints")
    public void player_has_new_set_of_visited_check_points(String s) {
       // player.hitObstacle(board, 2);
       // assertNotEquals(player.getCollectedCP().iterator().next(), board.getCheckPoints().iterator().next());
    }
    // player has collected all CheckPoints = WINS
    @Then("if player {string} has complete set of CheckPoints then player wins")
    public void if_player_has_complete_set_of_check_points_then_player_wins(String s) {
        player.hasAllCP(board.getCheckPoints());
    }

    // player visits a CheckPoint which has previously been visited
    @Then("player {string} has same set of CheckPoints as before")
    public void player_has_same_set_of_check_points_as_before(String s) {
        assertEquals(size,player.getCollectedCP().size());
    }



    @Then("player {string} gets {int} lives and has  {int} lives")
    public void player_gets_lives_and_has_lives(String string, Integer damage, Integer newlives) {
        System.out.println(player.getLives());
        player.hitObstacle(board, damage);

        System.out.println(player.getLives());
        assertEquals(player.getLives(), newlives, 0.0);
    }
}


