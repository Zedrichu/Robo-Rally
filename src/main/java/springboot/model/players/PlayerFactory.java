package springboot.model.players;

import java.util.HashSet;
import java.util.Set;

/**
 * Model class implementing the Factory design pattern for players
 */
public class PlayerFactory {

    /**
     * Method to generate a set of players, based on a set of unique names.
     * @param number - number of players to be generated
     * @param names - set of unique names needed for player generation
     * @return set of Player objects
     */
    public static Set<Player> getPlayerSet(int number, Set<String> names) {
        Set<Player> result = new HashSet<Player>();
        for (String name : names) {
            result.add(new Player(name));
        }
        return result;
    }

    /**
     * Method to generate a single player based on given name.
     * @param name - string holding the player's name
     * @return generated Player object
     */
    public static Player getPlayer(String name) { return new Player(name);}

}
