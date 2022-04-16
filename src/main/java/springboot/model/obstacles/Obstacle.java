package springboot.model.obstacles;

public abstract class Obstacle {
    Object damage;

    Obstacle(){}

    public void applyDamage(){
    }

    public Object getDamage() {
        return damage;
    }

}

