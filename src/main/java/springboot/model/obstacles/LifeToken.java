package springboot.model.obstacles;

import springboot.model.players.Player;

public class LifeToken extends Obstacle<Player, Integer>{

    @Override
    public void applyDamage(Player player, Integer integer) {
        player.updateLives(1);
    }

}

