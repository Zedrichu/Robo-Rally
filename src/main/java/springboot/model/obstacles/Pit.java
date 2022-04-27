package springboot.model.obstacles;

import springboot.model.players.Player;

public class Pit extends Obstacle{
    @Override
    public void applyDamage(Player player, int integer) {
        player.skipCard(integer);
    }
}
