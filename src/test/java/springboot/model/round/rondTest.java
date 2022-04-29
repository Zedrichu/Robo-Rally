package springboot.model.round;

import org.junit.jupiter.api.Test;
import springboot.model.players.Player;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    void testRound(){
        Player p1 = new Player("Sara");

        Set <Player> players = new HashSet<>();
        players.add(p1);
        players.add(new Player("Sabina"));

        Round round = new Round(players);
        round.setPlayers(players);
        assertSame(round.getPlayers(), players);
        assertFalse(round.checkNoCardsInHand());

    }

}
