package springboot.model.cards;
import java.util.ArrayList;


/**
 * Model class holding the hand of cards used by each player.
 * @TODO - needs to be deprecated, hold the card hand as ArrayList
 */
public class CardHand {
    private ArrayList<Card> hand;

    /**
     * Class constructor
     */
    public CardHand(ArrayList<Card> array) {
        this.hand = array;
    }

    /**
     * Card hand Getter
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Card hand Setter
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * Method returning the amount of cards in hand.
     */
    public int size() {return hand.size();}

    /**
     * Method to obtain the Card at given index in the hand.
     */
    public Card get(int i) {
        return hand.get(i);
    }

}
