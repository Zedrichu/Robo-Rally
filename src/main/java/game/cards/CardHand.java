package game.cards;

import java.util.ArrayList;

public class CardHand {
    private final static int drawNo = 9;
    private final static int cardsNo = 5;
    private ArrayList<Card> hand = new ArrayList<>();

    public ArrayList<Card> getHand() {
        return hand;
    }

    public CardHand(ArrayList<Card> array) {
        this.hand = array;
    }

    public void printHand(){
        for (Card card : hand){
            System.out.println(card.getName());
        }
    }

    public int size() {return hand.size();}



    // #TODO
}
