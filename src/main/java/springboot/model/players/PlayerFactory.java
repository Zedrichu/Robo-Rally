package springboot.model.players;

import game.players.Player;

import java.util.HashSet;
import java.util.Set;

//Implementing the Factory design pattern for Player objects generation
public class PlayerFactory {

    public static Set<Player> getPlayerSet(int number, Set<String> names) {
        Set<Player> result = new HashSet<Player>();
        for (String name : names) {
            result.add(new Player(name));
        }
        return result;
    }

    public static Player getPlayer(String name) { return new Player(name);}

}
