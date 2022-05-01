package springboot.model.board;

import org.junit.jupiter.api.Test;
import springboot.model.Direction;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest {

    @Test
    void testTiles(){

        Tile t = new Tile(TileType.ACID);

        t.setRobotOnTop(true, Direction.getRandomDirection());

        t.setRobotIcon("R1");

        assertEquals("R1", t.getRobotIcon());

        assertTrue(t.getRobotOnTop());

        assertNotNull(t.toString());

        assertNull(t.getPosition());

        assertNotNull(t.getType().getPictureFile());



    }
}
