package game.cards;

//CardFactory design pattern
public class CardFactory {

    public static Card getCard(CardType type, int intensifier) {
        return switch (type) {
            case MOVE -> new MovingCard(intensifier);
            case ROTATE -> new RotatingCard(intensifier * 90);
        };
    }
}
