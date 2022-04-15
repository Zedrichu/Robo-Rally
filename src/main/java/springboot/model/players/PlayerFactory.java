package springboot.model.players;

import game.players.Player;

import java.util.HashSet;
import java.util.Set;

//Implementing the Factory design pattern for Player objects generation
public class PlayerFactory {

    public static Set<Player> getPlayerSet(int number) {
        Set<Player> result = new HashSet<Player>();
        for (int i=0; i<number;i++) {
            result.add(new Player("Player"+(i+1)));
        }
        return result;
    }

}
