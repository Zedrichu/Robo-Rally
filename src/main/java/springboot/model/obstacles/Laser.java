package springboot.model.obstacles;

public class Laser extends Obstacle{

    public void applyDamage(){
        this.damage = -3;
    }
    public Laser(){}

    public Object getDamage() {
        return damage;
    }


}
