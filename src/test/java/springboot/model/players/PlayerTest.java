package springboot.model.players;

import org.junit.jupiter.api.Test;
import springboot.model.Direction;

import java.beans.PropertyChangeSupport;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testPlayer() {
        Player plr = PlayerFactory.getPlayer("Adrian");
        assertEquals(plr.getPlayerName(),"Adrian");

        plr.setRobot("Sara");
        assertTrue(plr.getRobot() == "Sara");

        assertTrue(PlayerFactory.getPlayer("sara").getPlayerName().equals("sara"));

        Player p1 = new Player("sara");
        p1.setPosition(1,2);
        p1.setDirection(Direction.getCardinalPointChar("N"));
        Player p2 = new Player("Rosie");
        p2.setPosition(1,2);

        p1.pushPlayer(p2);

        assertFalse(p1.getPosition() == p2.getPosition());



    }

}
