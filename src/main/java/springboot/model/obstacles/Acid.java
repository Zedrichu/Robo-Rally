package springboot.model.obstacles;

public class Acid extends Obstacle {
    int damage;
    public Acid(){
    }

    public void applyDamage(){
        this.damage = -2;
    }

    public Object getDamage() {
        return damage;
    }

}
