package springboot.model.cards;
import springboot.model.Position;
import springboot.model.Direction;

import java.util.Objects;

/**
 * Abstract model class denoting the cards used in the gameplay.
 */
abstract public class Card {
    private static long counter=0;
    long ID;
    private String name;

    /**
     * Card constructor
     */
    protected Card() {
        this.ID = counter++;
    }

    /**
     * Card name Setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Card name Getter
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method enforcing a card to be able to apply action on given position and direction.
     * @param position - Position object
     * @param direction - Direction object
     * @return tuple of new position and direction
     */
    abstract public Object[] applyAction(Position position, Direction direction);

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

/**
 * Inheriting model class denoting cards that are able to move.
 */
class MovingCard extends Card {
    final private int multiplier;

    /**
     * Class constructor
     * @param multiplier - intensity of the movement
     */
    protected MovingCard(int multiplier) {
        super();
        this.setName( multiplier<0? "Move"+Math.abs(multiplier)+"Backward"
                : "Move"+multiplier+"Forward");
        this.multiplier = multiplier;
    }

    /**
     * Method implementing the abstract method in the parent class
     */
    @Override
    public Object[] applyAction(Position position, Direction direction) {
        int angle = direction.getAngle();
        Position newPosition = position;
        if (angle % 360 == 0) {
            newPosition = new Position(position.x, position.y - this.multiplier);
        } else if (angle % 360 == 90) {
            newPosition = new Position(position.x + this.multiplier, position.y);
        } else if (angle % 360 == 180) {
            newPosition = new Position(position.x, position.y + this.multiplier);
        } else if (angle % 360 == 270){
            newPosition = new Position(position.x - this.multiplier, position.y);
        };
        return new Object[] {newPosition, direction};
    }

}

/**
 * Inheriting model class denoting cards that are able to rotate.
 */
class RotatingCard extends Card {
    final private int angle; //clockwise

    /**
     * Class constructor
     * @param angle - integer angle for rotation
     */
    protected RotatingCard(int angle) {
        super();
        String name = "Rotate";
        if (angle % 360 == 90) name += "Right";
        else if (angle % 360 == 180) name += "UTurn";
        else name += "Left";
        this.setName(name);
        this.angle = angle;
    }

    /**
     * Method implementing the abstract method in the parent class
     */
    @Override
    public Object[] applyAction(Position position, Direction direction) {
        try {
            Direction newDirection = Direction
                    .getCardinalPointByAngle((direction.getAngle() + angle) % 360);
            return new Object[] {position, newDirection};
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Object[] {position, direction};
        }
    }
}
