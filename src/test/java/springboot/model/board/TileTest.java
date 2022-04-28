package springboot.model.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest {

    @Test
    void testTiles(){

        Tile t = new Tile(TileType.ACID);

        t.setRobotOnTop(true);

        t.setRobotIcon("R1");

        assertTrue(t.getRobotIcon().equals("R1"));

        assertTrue(t.getRobotOnTop());

        assertNotNull(t.toString());

        assertNull(t.getPosition());
        assertNull(t.getDirection());

        assertNotNull(t.getType().getPictureFile());



    }
}
