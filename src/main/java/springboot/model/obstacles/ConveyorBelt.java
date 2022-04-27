package springboot.model.obstacles;

import springboot.model.players.Player;
import springboot.model.Position;
import springboot.model.cards.Card;
import springboot.model.cards.CardFactory;
import springboot.model.cards.CardType;

public class ConveyorBelt extends Obstacle<Player, Integer>{

    Card card = CardFactory.getCard(CardType.MOVE, 2);


    @Override
    public void applyDamage(Player player, Integer integer) {
        Object[] newPosDir = card.applyAction(player.getPosition(), player.getDirection());

        Position position = (Position) newPosDir[0];

        player.setPosition(position);
    }
}
