package springboot.model.obstacles;

import springboot.model.players.Player;

/**
 * Inheriting model class denoting the LifeToken obstacle
 */
public class LifeToken extends Obstacle{

    /**
     * Implementation of the abstract method of obstacle
     * @param player - Player object to gain more lives
     */
    @Override
    public void applyDamage(Player player, int integer) {
        player.updateLives(integer);
    }
}

