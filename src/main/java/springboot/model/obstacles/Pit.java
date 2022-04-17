package springboot.model.obstacles;

import game.players.Player;
import game.round.Round;

public class Pit extends Obstacle<Player, Integer>{
    @Override
    public void applyDamage(Player player, Integer integer) {
        player.skipCard(integer);
    }
}
