package springboot.model.obstacles;

public class LifeToken extends Obstacle{
    public LifeToken(){}
    int life;

    public void applyDamage(){
        this.life = 1;
    }

    public Object getDamage() {
        return life;
    }


}

