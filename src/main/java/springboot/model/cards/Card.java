package springboot.model.cards;
import springboot.model.Position;
import springboot.model.Direction;

import java.util.Objects;

abstract public class Card {
    private static long counter=0;
    long ID;
    private String name;

    protected Card() {
        this.ID = counter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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

class MovingCard extends Card {
    final private int multiplier;

    // Constructor for MovingCard
    protected MovingCard(int multiplier) {
        super();
        this.setName( multiplier<0? "Move"+Math.abs(multiplier)+"Backward"
                : "Move"+multiplier+"Forward");
        this.multiplier = multiplier;
    }


    // Function to apply an action based on a moving card
    @Override
    public Object[] applyAction(Position position, Direction direction) {
        int angle = direction.getAngle();
        Position newPosition = position;
        if (angle == 0) {
            newPosition = new Position(position.x, position.y - this.multiplier);
        } else if (angle == 90) {
            newPosition = new Position(position.x + this.multiplier, position.y);
        } else if (angle == 180) {
            newPosition = new Position(position.x, position.y + this.multiplier);
        } else if (angle == 270){
            newPosition = new Position(position.x - this.multiplier, position.y);
        };
        return new Object[] {newPosition, direction};
    }

}

class RotatingCard extends Card {
    final private int angle; //clockwise

    protected RotatingCard(int angle) {
        super();
        String name = "Rotate";
        if (angle == 90) name += "Right";
        else if (angle == 180) name += "UTurn";
        else name += "Left";
        this.setName(name);
        this.angle = angle;
    }

    @Override
    public Object[] applyAction(Position position, Direction direction) {
        Direction newDirection = Direction
                .getCardinalPointByAngle((direction.getAngle()+angle)%360);
        return new Object[] {position, newDirection};
    }
}
