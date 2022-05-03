package springboot.model.cards;


import java.util.*;

/**
 * Model class denoting the deck of cards to be used during the gameplay.
 *  Client of the Card Factory design pattern.
 */
public class CardDeck {

    final private Random random = new Random();
    private final Set<Card> deck = new HashSet<>();
    private int deckSize = 84;

    /**
     * Card deck constructor
     */
    public CardDeck() {
        CardType[] types = {CardType.MOVE, CardType.MOVE, CardType.MOVE, CardType.MOVE, CardType.ROTATE, CardType.ROTATE, CardType.ROTATE};
        int[] cardinality = {18, 12, 6, 6, 18, 18, 6};
        int[] intensities = {1, 2, -1, 3, 1, 3, 2};

        for (int i = 0; i< types.length; i++) {
            for (int j = 0; j< cardinality[i]; j++) {
                deck.add(CardFactory.getCard(types[i], intensities[i]));
            }
        }
    }



    /**
     * Method for random selection of a number of  cards out of the card deck.
     * @param number - number of cards requested for withdrawal
     * @return array of cards
     */
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

    /**
     * Method to restore an array of card back to the card deck
     * @param cards - array of cards to be returned to the card deck
     */
    public void restoreCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    /**
     * Deck size Getter
     */
    public int getDeckSize() {
        return deckSize;
    }
}