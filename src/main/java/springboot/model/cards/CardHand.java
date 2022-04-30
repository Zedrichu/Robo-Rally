package springboot.model.cards;

import java.util.ArrayList;


// Think of scrapping this class and use ArrayList<Card> as field
public class CardHand {
    private ArrayList<Card> hand;

    public CardHand(ArrayList<Card> array) {
        this.hand = array;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int size() {return hand.size();}

    public Card get(int i) {
        return hand.get(i);
    }
// #TODO
//  public void removeCard(){
//      hand.set(round.getRoundNumber(),null);
//  }
}
