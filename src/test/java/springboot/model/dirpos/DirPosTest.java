package springboot.model.dirpos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import springboot.model.Position;
import springboot.model.Direction;

import java.util.Arrays;

class DirPosTest {
    @Test
    void testEverything() {
        assertNull(Direction.getCardinalPointChar("A"));
        assertNull(Direction.getCardinalPointByAngle(65));
        Direction randomDirection = Direction.getRandomDirection();
        assertEquals(randomDirection.getAngle(), Direction.getCardinalPointByAngle(randomDirection.getAngle()).getAngle());
        assertNull(Direction.getCardinalPointByAngle(45));
        assertNotNull(new Position(5,3).toString());
        assertNotEquals(new Position(3,4).hashCode(), new Position(4,3).hashCode());
        assertEquals(new Position(3,4).hashCode(), new Position(3,4).hashCode());
        for (int i=0; i<100;i++){
            Direction dir = Direction.getRandomDirection();
            assertTrue(Arrays.asList(Direction.values()).contains(dir));
        }


    }

    }
