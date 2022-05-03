package springboot.model.obstacles;

import springboot.model.players.Player;

/**
 * Inheriting model class denoting the Laser obstacle
 */
public class Laser extends Obstacle{

    /**
     * Implementation of the abstract method of obstacle
     * @param player - Player object to take damage
     */
    @Override
    public void applyDamage(Player player, int integer) {
        player.updateLives(-integer);
    }

}
