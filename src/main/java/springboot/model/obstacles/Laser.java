package springboot.model.obstacles;

import game.players.Player;

public class Laser extends Obstacle{

    public void applyDamage(Player player){
        player.updateLives(-1);
    }
    public Laser(){}

    public Object getDamage() {
        return damage;
    }


}
