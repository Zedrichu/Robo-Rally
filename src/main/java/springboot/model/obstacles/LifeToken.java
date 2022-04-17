package springboot.model.obstacles;

import game.players.Player;

public class LifeToken extends Obstacle{
    public LifeToken(){}
    int life;

    public void applyDamage(Player player){
        player.updateLives(2);
    }

    public Object getDamage() {
        return life;
    }


}

