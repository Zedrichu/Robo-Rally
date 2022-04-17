package springboot.model.obstacles;

import game.players.Player;

public class Acid extends Obstacle {
    int damage;
    public Acid(){
    }

    public void applyDamage(Player player){
        player.updateLives(-2);
    }

    public Object getDamage() {
        return damage;
    }

}
