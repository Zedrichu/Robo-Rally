package springboot.model.obstacles;

public abstract class Obstacle<Player, int> {
    Object damage;

    Obstacle(){}

    public abstract void applyDamage();

    public Object getDamage() {
        return damage;
    }
}

