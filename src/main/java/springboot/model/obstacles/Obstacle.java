package springboot.model.obstacles;

import springboot.model.players.Player;

public abstract class Obstacle<R> {

    public abstract void applyDamage(Player player, R damage);

}

