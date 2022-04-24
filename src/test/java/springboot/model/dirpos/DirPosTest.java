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
    }



}
