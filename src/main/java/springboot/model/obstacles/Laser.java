package springboot.model.obstacles;

import game.players.Player;

public class Laser extends Obstacle<Player, Integer>{

    @Override
    public void applyDamage(Player player, Integer integer) {
        player.updateLives(-1);
    }

}
