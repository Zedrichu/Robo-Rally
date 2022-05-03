package springboot.model.obstacles;

import springboot.model.players.Player;

/**
 * Inheriting model class denoting the Acid obstacle
 */
public class Acid extends Obstacle {

    /**
     * Implementation of the abstract method of obstacle
     * @param player - Player object to take damage
     */
    @Override
    public void applyDamage(Player player, int damage) {
        player.updateLives(-damage);
    }

}
