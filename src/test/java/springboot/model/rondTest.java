package springboot.model;

import org.junit.jupiter.api.Test;
import springboot.model.cards.CardDeck;
import springboot.model.players.Player;

import java.net.CacheRequest;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    void testRound(){
        Player p1 = new Player("Sara");
        CardDeck deck = new CardDeck();

        Set <Player> players = new HashSet<>();
        players.add(p1);
        players.add(new Player("Sabina"));

        Round round = new Round(players);
        round.setPlayers(players);
        assertSame(round.getPlayers(), players);
        assertFalse(round.checkNoCardsInHand());

        round.drawCardsAll(deck);

        assertEquals(round.getRoundNumber(), 1);


    }

}
