package springboot.model.players;

import org.junit.jupiter.api.Test;

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



    }

}
