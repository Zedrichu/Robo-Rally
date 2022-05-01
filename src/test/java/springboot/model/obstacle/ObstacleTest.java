package springboot.model.obstacle;

import org.junit.jupiter.api.Test;
import springboot.model.obstacles.*;
import springboot.model.players.Player;

import static org.junit.jupiter.api.Assertions.*;

public class ObstacleTest {
    @Test
    void testObstacle(){
        Player p = new Player("sara");
        p.setLives(3);
        Obstacle o4 = new CheckPoint();
        Obstacle o5 = new CheckPoint();
        Obstacle o6 = new LifeToken();

        assertFalse(o4.equals(o5));
        assertTrue(o4.equals(o4));

        o4.applyDamage(new Player("sara"), 0);

        o6.applyDamage(p, 2);
        assertEquals(p.getLives(), 5);



    }

}
