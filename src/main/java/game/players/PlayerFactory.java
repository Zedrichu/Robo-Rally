package game.players;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Player Factory
public class PlayerFactory {

    public static Player getPlayer(String name) {
        return new Player(name);
    }

    public static Set<Player> getPlayerSet(int number) {
        Set<Player> result = new HashSet<Player>();
        for (int i=0; i<number;i++) {
            result.add(getPlayer(selectPlayerName()));
        }
        return result;
    }

    public static String selectPlayerName(){
        System.out.println("Please enter the player's name: ");
        Scanner s = new Scanner(System.in);
        String res = s.next();
        s.close();
        return res;
    }
}
