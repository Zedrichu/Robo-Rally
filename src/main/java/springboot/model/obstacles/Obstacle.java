package springboot.model.obstacles;

import springboot.model.players.Player;

/**
 * Abstract model class denoting the obstacles encountered in the game.
 */
public abstract class Obstacle {

    /**
     * Method allowing the obstacles to apply damage on given player
     * @param player - Player object to take damage
     * @param damage - damage to be given by obstacle
     */
    public abstract void applyDamage(Player player, int damage);
}

