package springboot.model.cards;

/**
 * Factory model class used to generate cards based on given card type and intensifier.
 */
public class CardFactory {

    /**
     * Method generating a card based on given type and intensifier.
     * @param type - CardType enum option
     * @param intensifier - multiplier of the card's effect
     * @return generated Card
     */
    public static Card getCard(CardType type, int intensifier) {
        return switch (type) {
            // 1 for 1 step forward, -1 for 1 step backward, 2 for 2 steps forward
            case MOVE -> new MovingCard(intensifier);
            // 1 for turn right, 3 for turn left, 2 for U turn
            case ROTATE -> new RotatingCard(intensifier * 90);
        };
    }
}
