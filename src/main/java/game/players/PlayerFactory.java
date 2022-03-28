package game.players;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Player Factory
public class PlayerFactory {
    private final static Scanner s = new Scanner(System.in);

    public static Player getPlayer(String name) {
        return new Player(name);
    }

    public static void main(String[] args) {
        Player plr = getPlayer("Adrian");
        System.out.println(plr.getPlayerName()+"__"+plr.getPlayerID());

        Set<Player> set = getPlayerSet(2);
        for (Player item : set) {
            System.out.println(item.getPlayerName()+"__"+item.getPlayerID());
        }

        s.close();
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
        return s.nextLine();
    }
}
