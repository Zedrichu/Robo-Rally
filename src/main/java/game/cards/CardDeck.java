package game.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//interface Card {
 //   public void action();
//}

enum CardValue{
    MOVEON(1,18,"MoveOn"),
    MOVEONTWO(2,12,"MoveOn2"),
    MOVEONTHREE(3,6,"MoveOn3"),
    MOVEBACK(1,6,"MoveBack"),
    ROTATELEFT(3,18,"RotateLeft"),
    ROTATERIGHT(1,18,"RotateRight"),
    UTURN(2,6,"UTurn");

    final private int value;
    final private int number;
    final private String name;

    CardValue(int value, int number, String name){
        this.value = value;
        this.number = number;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

}

public class CardDeck {
    private ArrayList<CardValue> deck;

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
    }

    public CardDeck() {
        this.deck = new ArrayList<CardValue>(84);
        CardValue[] cards = CardValue.values();

        for (CardValue card: cards) {
            for (int i=0; i<card.getNumber();i++){
                deck.add(card);
            }
        }

        Collections.shuffle(deck);

        Iterator<CardValue> cardIterator = deck.iterator();
        while (cardIterator.hasNext()) {
            CardValue aCard = cardIterator.next();
            System.out.println(aCard.getName());
        }

    }
}



