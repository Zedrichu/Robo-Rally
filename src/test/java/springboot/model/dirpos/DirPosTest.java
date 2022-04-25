package springboot.model.dirpos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import springboot.model.Position;
import springboot.model.Direction;

class DirPosTest {
    @Test
    void testEverything() {
        assertNull(Direction.getCardinalPointChar("A"));
        assertNull(Direction.getCardinalPointByAngle(45));
        assertNotNull(new Position(5,3).toString());
        assertNotEquals(new Position(3,4).hashCode(), new Position(4,3).hashCode());
        assertEquals(new Position(3,4).hashCode(), new Position(3,4).hashCode());
    }



}
