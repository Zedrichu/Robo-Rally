package springboot.model.gamesettings;

import org.junit.jupiter.api.Test;
import springboot.model.GameSettings;
import springboot.model.players.Player;

import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class gameSettingTest {
    @Test
    void testGameSettings() {

        Set <Player> players = new HashSet<Player>();
        players.add(new Player("Sara"));
        players.add(new Player("jeppe"));

        GameSettings settings = new GameSettings();
        settings.setPlayers(players);
        assertSame(settings.getPlayers(), players);

        settings.setPlayers(players);
    }

}
