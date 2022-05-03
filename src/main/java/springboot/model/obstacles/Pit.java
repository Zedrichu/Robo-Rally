package springboot.model.obstacles;

import springboot.model.players.Player;

/**
 * Inheriting model class denoting the Pit obstacle
 */
public class Pit extends Obstacle{

    /**
     * Implementation of the abstract method of obstacle
     * @param player - Player object to take damage
     * @param integer - index of card to be removed
     */
    @Override
    public void applyDamage(Player player, int integer) {
        player.skipCard(integer);
    }
}
