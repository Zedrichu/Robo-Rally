package springboot.model.gamesettings;

import org.junit.jupiter.api.Test;
import springboot.model.Complexity;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.players.Player;

import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameSettingTest {
    @Test
    void testGameSettings() {

        Set <Player> players = new HashSet<Player>();
        players.add(new Player("Sara"));
        players.add(new Player("jeppe"));

        GameSettings settings = new GameSettings();
        settings.setPlayers(players);
        assertSame(settings.getPlayers(), players);

        settings.setPlayers(players);

        GameSettings settings2 = new GameSettings();
        settings2.setComplexity(Complexity.EASY);
        int[] sizes = settings2.getBoardSize();
        Board x = new Board(sizes[0],sizes[1]);
        assertEquals(9,x.getCols());

        settings2 = new GameSettings();
        settings2.setComplexity(Complexity.MEDIUM);
        sizes = settings2.getBoardSize();
        x = new Board(sizes[0],sizes[1]);
        assertEquals(11,x.getCols());

        settings2 = new GameSettings();
        settings2.setComplexity(Complexity.HARD);
        sizes = settings2.getBoardSize();
        x = new Board(sizes[0],sizes[1]);
        assertEquals(13,x.getCols());
    }

}
