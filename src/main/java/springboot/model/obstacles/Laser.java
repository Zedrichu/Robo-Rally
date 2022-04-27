package springboot.model.obstacles;

import springboot.model.players.Player;

public class Laser extends Obstacle{

    @Override
    public void applyDamage(Player player, int integer) {
        player.updateLives(-1);
    }

}
