package game.cards;

import game.Position;
import game.players.Player;
import view.CardinalPoints;

import java.util.*;

public class CardDeck {
    //Client of CardFactory - Singleton Design Pattern
    private static CardDeck instance;
    private Set<Card> deck = new HashSet<>();
    private int deckSize = 84;

    private CardDeck() {

    }

    public ArrayList<Card> drawCards(){
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i<9;i++) {
            int val = random.nextInt(0,deck.size());
            for (Card c : deck) {
                if (val==0) {
                    hand.add(c);
                    deck.remove(c);
                    break;
                }
                val--;
            }
        }
        return hand;
    }

    public static CardDeck getInstance() {
        if (instance == null) {
            instance = new CardDeck();
        }
        return  instance;
    }
    public void printCardDeck(){
        for (Card card : deck){
            System.out.println(card.getName());
        }
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public int getDeckSize() {
        return deckSize;
    }
}