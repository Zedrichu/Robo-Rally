package springboot.model.obstacles;

public abstract class Obstacle<P, R> {

    public abstract void applyDamage(P p, R r);

}

