package springboot.model.cards;

import java.util.*;

public class CardDeck {
    //Client of the CardFactory
    final private Random random = new Random();
    private final Set<Card> deck = new HashSet<>();
    private int deckSize = 84;
    private int[] cardinality = {18,12,6,6,18,18,6};
    private CardType[] types = {CardType.MOVE,CardType.MOVE,CardType.MOVE,CardType.MOVE,CardType.ROTATE,CardType.ROTATE,CardType.ROTATE};
    private int[] intensities = {1,2,3,-1,1,-1,2};

    public CardDeck() {
        for (int i=0;i<types.length;i++) {
            for (int j=0; j<cardinality[i];j++) {
                deck.add(CardFactory.getCard(types[i],intensities[i]));
            }
        }
    }

    //Method for random selection of 9 cards out of the Set<Card< deck
    public ArrayList<Card> drawCards(int number){
        ArrayList<Card> draws = new ArrayList<>();
        for (int i = 0; i<number;i++) {
            int val = random.nextInt(0,deck.size());
            for (Card c : deck) {
                if (val==0) {
                    draws.add(c);
                    deck.remove(c);
                    break;
                }
                val--;
            }
        }
        return draws;
    }

    public int getDeckSize() {
        return deckSize;
    }
}