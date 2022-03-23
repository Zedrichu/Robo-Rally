package gameSettings;
import game.*;
import static org.junit.Assert.*;
import game.GameSettings;
import io.cucumber.java.en.*;
import view.widgets.*;

import java.util.HashSet;
import java.util.Set;


public class StepDef {
    GameSettings gameSettings;
    Complexity c;
    Set<Player> sps;
    long id;

    @Given("a board_ID")
    public void a_board_id() {
        Board brd = new Board(10,12);
        id = brd.getBoardID();
        assertNotNull(id);
    }
    @Given("a complexity")
    public void a_complexity() {
        c = Complexity.EASY;
        assertNotNull(c);
    }
    @Given("set of player settings")
    public void set_of_player_settings() {
        sps = new HashSet<Player>(8);
        assertNotNull(sps);

    }
    @When("create game settings")
    public void create_game_settings() {
        gameSettings = new GameSettings(id,c,sps);
        assertNotNull(gameSettings);
    }
    @Then("game initialisation")
    public void game_initialisation() {
        System.out.println("Game is initialised");
    }

}
