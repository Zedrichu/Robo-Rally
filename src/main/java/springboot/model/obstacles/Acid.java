package springboot.model.obstacles;

import springboot.model.players.Player;

public class Acid extends Obstacle {

    @Override
    public void applyDamage(Player player, int int1) {
        player.updateLives(-2);
    }

}
