package springboot.model.obstacles;

import springboot.model.players.Player;

public class Laser extends Obstacle<Integer>{

    @Override
    public void applyDamage(Player player, Integer integer) {
        player.updateLives(-1);
    }

}
