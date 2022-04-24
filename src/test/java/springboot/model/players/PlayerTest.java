package springboot.model.players;

import game.players.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testPlayer() {
        Player plr = PlayerFactory.getPlayer("Adrian");
        assertEquals(plr.getPlayerName(),"Adrian");
    }

}
