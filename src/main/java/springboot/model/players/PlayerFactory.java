package springboot.model.players;

import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

//Implementing the Factory design pattern for Player objects generation
public class PlayerFactory {

    public static Set<Player> getPlayerSet(PropertyChangeSupport support, int number, Set<String> names) {
        Set<Player> result = new HashSet<Player>();
        for (String name : names) {
            result.add(new Player(support, name));
        }
        return result;
    }

    public static Player getPlayer(PropertyChangeSupport support, String name) { return new Player(support, name);}

}
