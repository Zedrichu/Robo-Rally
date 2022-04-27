package springboot.model.board;

import org.junit.jupiter.api.Test;
import springboot.model.Position;
import springboot.model.players.Player;

import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {

    @Test
    void testPlayer() {
       // Tile[][] board;
        Board b = new Board(new PropertyChangeSupport(this),10, 10);
        Board b1 = new Board(new PropertyChangeSupport(this),10, 10);
        Board b2 = new Board(new PropertyChangeSupport(this),10, 10);
        assertEquals(b.getCols(), 10);
        assertEquals(b.getRows(), 10);

        assertTrue(Arrays.deepEquals(b.getBoard(), new Board(new PropertyChangeSupport(this),10, 10).getBoard()));

        b1.loadRandomBoard(2);

        b1.getStartTiles();

        assertNotNull(b1.getRandomStartPosition());

        Set<Player> players = new HashSet<Player>();

       // Tile tile1 = new Tile(TileType.LASER);
       // Tile tile2 = new Tile(TileType.LASER);


       // tile2.position = new Position(2,1);
       // tile1.position = new Position(1,2);

        Player p1 = new Player(new PropertyChangeSupport(this),"Sara");
        Player p2 = new Player(new PropertyChangeSupport(this),"jeppe");
        p1.setPosition(2,1);
        p2.setPosition(1,2);

        players.add(p1);
        players.add(p2);

        //b.placePlayers(players);
    }

}