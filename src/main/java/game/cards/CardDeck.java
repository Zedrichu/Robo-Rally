package game.cards;

import java.util.*;

public class CardDeck {
    //Client of CardFactory - Singleton Design Pattern
    private static CardDeck instance;
    private Random random = new Random();
    private Set<Card> deck = new HashSet<>();
    private int deckSize = 84;
    private int[] cardinality = {18,12,6,6,18,18,6};
    private CardType[] types = {CardType.MOVE,CardType.MOVE,CardType.MOVE,CardType.MOVE,CardType.ROTATE,CardType.ROTATE,CardType.ROTATE};
    private int[] intensities = {1,2,3,-1,1,-1,2};

    private CardDeck() {
        for (int i=0;i<types.length;i++) {
            for (int j=0; j<cardinality[i];j++) {
                deck.add(CardFactory.getCard(types[i],intensities[i]));
            }
        }
    }

    //Method for random selection of 9 cards out of the Set<Card< deck
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