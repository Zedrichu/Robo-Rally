package springboot.model.players;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeSupport;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testPlayer() {
        Player plr = PlayerFactory.getPlayer(new PropertyChangeSupport(this),"Adrian");
        assertEquals(plr.getPlayerName(),"Adrian");
    }

}
