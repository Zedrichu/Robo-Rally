package springboot.model.round;

import org.junit.jupiter.api.Test;
import springboot.model.players.Player;

import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RoundTest {

    @Test
    void testRound(){
        Player p1 = new Player(new PropertyChangeSupport(this), "Sara");

        Set <Player> players = new HashSet<>();
        players.add(p1);
        players.add(new Player(new PropertyChangeSupport(this),"Sabina"));

        Round.getInstance(new PropertyChangeSupport(this),players).setPlayers(players);
        assertTrue(Round.getInstance(new PropertyChangeSupport(this),players).getPlayers() == players);

        assertTrue(!Round.getInstance(new PropertyChangeSupport(this),players).checkNoCardsInHand());











    }

}
