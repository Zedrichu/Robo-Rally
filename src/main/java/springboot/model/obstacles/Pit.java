package springboot.model.obstacles;

import game.players.Player;
import game.round.Round;

public class Pit extends Obstacle{

    public void applyDamage(Player player, int round){
        player.skipCard(round);
    }

}
