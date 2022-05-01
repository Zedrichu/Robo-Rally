package springboot.model.obstacles;

import springboot.model.players.Player;

public class LifeToken extends Obstacle{

    @Override
    public void applyDamage(Player player, int integer) {
        player.updateLives(integer);
    }

}

