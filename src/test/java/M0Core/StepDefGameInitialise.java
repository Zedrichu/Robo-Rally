package M0Core;

import static org.junit.Assert.*;

import springboot.model.Complexity;
import springboot.model.GameSettings;
import springboot.model.Position;
import springboot.model.cards.CardDeck;
import springboot.model.players.Player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import springboot.model.board.TileType;
import springboot.model.board.Board;

import java.beans.PropertyChangeSupport;


public class StepDefGameInitialise {

    GameSettings gameSettings;
    CardDeck deck = new CardDeck();
    Board board;


    @Given("game settings with EASY and {int} players")
    public void game_settings(int x) {
        gameSettings = new GameSettings();
        gameSettings.setAmountOfPlayers(x);
        gameSettings.setComplexity(Complexity.EASY);
        gameSettings.setAmountOfPlayers(x);
        assertEquals(Complexity.EASY, gameSettings.getComplexity());
        assertEquals(x,gameSettings.getAmountOfPlayers());
    }

    @Given("cardDeck")
    public void card_deck() {

        deck = new CardDeck();
        assertEquals(84, deck.getDeckSize());
    }

    @When("game initialisation")
    public void game_initialisation(){
        int[] size = gameSettings.getBoardSize();
        board = new Board(size[0], size[1]);
        board.loadRandomBoard(gameSettings.getAmountOfPlayers());
        for (Player plr : gameSettings.getPlayers()){
            plr.setPosition(board.getRandomStartPosition());
        }
    }

    @Then("players are on starting tiles")
    public void players_are_on_starting_tiles() {
        for (Player plr : gameSettings.getPlayers()){
            Position pos = plr.getPosition();
            assertSame(board.getBoard()[pos.y][pos.x].getType(), TileType.STARTING);
        }
    }
}
