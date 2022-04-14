package game.cards;
import game.round.Position;
import view.CardinalPoints;

import java.util.Objects;

abstract public class Card {
    private static long counter=0;
    private CardType type;
    long ID;
    private String name;

    //boolean faceUp = true;
    //void flipCard()

    Card(CardType type) {
        this.ID = counter++;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public Object[] applyAction(Position position, CardinalPoints direction);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return ID == card.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}

class MovingCard extends Card {
    final private int multiplier;

    // Constructor for MovingCard
    protected MovingCard(int multiplier) {
        super(CardType.MOVE);
        this.setName( multiplier<0? "Move"+Math.abs(multiplier)+"Back"
                : "Move"+multiplier+"Forward");
        this.multiplier = multiplier;
    }


    // Function to apply an action based on a moving card
    @Override
    public Object[] applyAction(Position position, CardinalPoints direction) {
        int angle = direction.getAngle();
        Position newPosition = switch (angle) {
            case 0 -> new Position(position.x, position.y - this.multiplier);
            case 90 -> new Position(position.x + this.multiplier, position.y);
            case 180 -> new Position(position.x, position.y + this.multiplier);
            case 270 -> new Position(position.x - this.multiplier, position.y);
            default -> null;
        };
        return new Object[] {newPosition, direction};
    }

}

class RotatingCard extends Card {
    final private int angle; //clockwise

    protected RotatingCard(int angle) {
        super(CardType.ROTATE);
        String name = "Rotate";
        if (angle == 90) name += "Right";
        else if (angle == 180) name += "UTurn";
        else name += "Left";
        this.setName(name);
        this.angle = angle;
    }

    @Override
    public Object[] applyAction(Position position, CardinalPoints direction) {
        CardinalPoints newDirection = CardinalPoints
                .getCardinalPointByAngle((direction.getAngle()+angle)%360);
        return new Object[] {position, newDirection};
    }
}
