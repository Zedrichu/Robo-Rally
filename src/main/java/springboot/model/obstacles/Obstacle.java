package springboot.model.obstacles;

import springboot.model.players.Player;

public abstract class Obstacle {

    public abstract void applyDamage(Player player, int damage);

}

