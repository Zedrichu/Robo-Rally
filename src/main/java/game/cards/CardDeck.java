package game.cards;

import game.Position;
import game.players.Player;
import view.CardinalPoints;

import java.util.*;

abstract class Card {
    private static long counter=0;
    long ID;
    private String name;

    //boolean faceUp = true;
    //void flipCard()

    Card() {
        this.ID = counter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public Object[] applyAction(Position position, CardinalPoints direction);
}

class MovingCard extends Card {
    final private int multiplier;

    protected MovingCard(int multiplier, String name) {
        super();
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

class RotatingCard extends Card{
    final private int angle; //clockwise

    protected RotatingCard(int angle, String name) {
        super();
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


public class CardDeck {
    private Set<Card> deck;
    private int initCapacity = 84;
    private Card[] initialConfig = {};
    private int[] cardinal = {18, 12, 6, 6, 18, 18, 6};

    //setCardinal

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        deck.printDeck();
    }

    public CardDeck() {
        this.deck = new HashSet<>(initCapacity);

        for (int i : cardinal)
            for (int j = 0; j < i; j++) {
                System.out.println("X");
            }
    }

    public void printDeck(){
        Iterator<Card> cardIterator = deck.iterator();
        while (cardIterator.hasNext()) {
            Card card = cardIterator.next();
            System.out.println(card.getName());
        }
    }
}



