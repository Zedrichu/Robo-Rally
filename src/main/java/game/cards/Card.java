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
        this.ID = counter++; this.type = type;
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

    protected MovingCard(int multiplier, String name) {
        super(CardType.MOVE);
        this.setName(name);
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

    protected RotatingCard(int angle, String name) {
        super(CardType.ROTATE);
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

class MoveF1 extends MovingCard {
    MoveF1() {
        super(1,"Move1Forward");
    }
}

class MoveF2 extends MovingCard {
    MoveF2() {super(2,"Move2Forward");}
}

class MoveF3 extends MovingCard {
    MoveF3() {super(3,"Move3Forward");}
}

class MoveB1 extends MovingCard {
    MoveB1() {super(-1,"Move1Back");}
}

class RotateLeft extends RotatingCard {
    RotateLeft() {super(270,"RotateLeft");}
}

class RotateRight extends RotatingCard {
    RotateRight() {super(90,"RotateRight");}
}

class UTurn extends RotatingCard {
    UTurn() {super(180,"UTurn");}
}