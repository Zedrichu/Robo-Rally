package springboot.model.board;

import org.junit.jupiter.api.Test;
import springboot.model.Position;
import springboot.model.players.Player;

import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testBoard() {
       // Tile[][] board;
        Board b = new Board(10, 10);
        Board b1 = new Board(10, 10);
        Board b2 = new Board(10,10);
        assertEquals(b.getCols(), 10);
        assertEquals(b.getRows(), 10);

        assertTrue(Arrays.deepEquals(b.getBoard(), new Board(10, 10).getBoard()));

        b1.loadRandomBoard(2);

        b1.getStartTiles();

        b2.loadBoard_Easy();
        assertNotNull(b2.getBoard());

        b2.loadBoard_Medium();
        assertNotNull(b2.getBoard());

        b2.loadBoard_Hard();
        assertNotNull(b2.getBoard());


        assertNotNull(b1.getRandomStartPosition());

        Set<Player> players = new HashSet<Player>();

        Player p1 = new Player("Sara");
        Player p2 = new Player("jeppe");
        p1.setPosition(2,1);
        p2.setPosition(1,2);

        players.add(p1);
        players.add(p2);

        b1.placePlayers(players);
        assertNotNull(p1.getPosition());
        assertNotNull(p2.getPosition());


    }

}