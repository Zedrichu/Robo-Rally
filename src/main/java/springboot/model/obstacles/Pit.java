package springboot.model.obstacles;

import springboot.model.players.Player;

public class Pit extends Obstacle<Integer>{
    @Override
    public void applyDamage(Player player, Integer integer) {
        player.skipCard(integer);
    }
}
