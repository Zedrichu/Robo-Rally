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
        try {
            assertNull(Direction.getCardinalPointByAngle(65));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Direction randomDirection = Direction.getRandomDirection();
        try {
            assertEquals(randomDirection.getAngle(), Direction.getCardinalPointByAngle(randomDirection.getAngle()).getAngle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            assertNull(Direction.getCardinalPointByAngle(45));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertNotNull(new Position(5,3).toString());
        assertNotEquals(new Position(3,4).hashCode(), new Position(4,3).hashCode());
        assertEquals(new Position(3,4).hashCode(), new Position(3,4).hashCode());
        for (int i=0; i<100;i++){
            Direction dir = Direction.getRandomDirection();
            assertTrue(Arrays.asList(Direction.values()).contains(dir));
        }


    }

    }
