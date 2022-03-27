package game.cards;

//CardFactory design pattern
public class CardFactory {

    public static Card getCard(CardType type, int intensifier) {
        return switch (type) {
            // 1 for 1 step forward, -1 for 1 step backward, 2 for 2 steps forward
            case MOVE -> new MovingCard(intensifier);
            // 1 for turn right, -1 for turn left, 2 or -2 for U turn
            case ROTATE -> new RotatingCard(intensifier * 90);
        };
    }
}
