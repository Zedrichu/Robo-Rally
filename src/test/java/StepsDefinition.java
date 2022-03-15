import io.cucumber.java.en.*;
import view.widgets.*;


public class StepsDefinition {
    GameSettings gameSettings;
    @Given("{int} players")
    public void players(Integer int1) {

    }
    @And("a game setting")
    public void a_game_setting() {
        GameSettings gameSettings = new GameSettings(2,Complexity.EASY);
    }
    @And("a board with size")
    public void a_board_with_size() {
        Board board = new Board(10,12);
    }
    @Given("a deck of cards")
    public void a_deck_of_cards() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("game initialisation")
    public void game_initialisation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("generate board")
    public void generate_board() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("view board")
    public void view_board() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
