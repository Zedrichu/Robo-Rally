package springboot.model.obstacles;

import game.players.Player;

public class Pit extends Obstacle<Player, Integer>{
    @Override
    public void applyDamage(Player player, Integer integer) {
        player.skipCard(integer);
    }
}
