package game.cards;
import game.cards.*;
import game.Position;
import view.CardinalPoints;

enum CardType {
    MOVE, ROTATE;
}

abstract class Card {
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

    public void setType(CardType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    abstract public Object[] applyAction(Position position, CardinalPoints direction);
}

class MovingCard extends Card {
    final private int multiplier;

    protected MovingCard(int multiplier) {
        super(CardType.MOVE);
        this.setName( multiplier<0? "Move"+Math.abs(multiplier)+"Back"
                : "Move"+multiplier+"Forward");
        this.multiplier = multiplier;
    }

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
        this.setName("Rotate");
        this.angle = angle;
    }

    @Override
    public Object[] applyAction(Position position, CardinalPoints direction) {
        CardinalPoints newDirection = CardinalPoints
                .getCardinalPointByAngle((direction.getAngle()+angle)%360);
        return new Object[] {position, newDirection};
    }
}
