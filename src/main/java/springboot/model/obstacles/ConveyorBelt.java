package springboot.model.obstacles;

import game.players.Player;
import springboot.model.Position;
import springboot.model.cards.Card;
import springboot.model.cards.CardFactory;
import springboot.model.cards.CardType;

public class ConveyorBelt extends Obstacle{

    Card card = CardFactory.getCard(CardType.MOVE, 2);

    public void applyDamage(Player player){
        Object[] newPosDir = card.applyAction((Position) damage, player.getDirection());

        Position position = (Position) newPosDir[0];

        player.setPosition(position);
    }

}
