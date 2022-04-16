package springboot.model.obstacles;

import game.players.Player;
import springboot.model.Position;
import springboot.model.cards.Card;
import springboot.model.cards.CardFactory;
import springboot.model.cards.CardType;

public class ConveyorBelt extends Obstacle{
    Player player;
    Position position;

    public ConveyorBelt(Position position, Player player){
        this.damage = position;
        this.player = player;
    }

    Card card = CardFactory.getCard(CardType.MOVE, 2);

    public void applyDamage(){
        Object[] newPosDir = card.applyAction((Position) damage, player.getDirection());

        this.position = (Position) newPosDir[0];

        player.setPosition(position);
    }
    public Position getDamage(){
        return position;
    }

}
