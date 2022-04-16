package springboot.model.obstacles;

import game.players.Player;
import game.round.Round;

public class Pit extends Obstacle{
    Player player;
    Round round;

    public Pit(Player player, Round round){
        this.player = player;
        this.round = round;
    }

    public void applyDamage(){
        player.skipCard(round.getRoundNumber());
    }

}
