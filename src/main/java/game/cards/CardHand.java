package game.cards;

import java.util.LinkedList;
import game.round.Round;

public class CardHand {
    private final static int drawNo = 9;
    private final static int cardsNo = 5;
    private LinkedList<Card> hand= new LinkedList<>();
    private Round round;

    public int size() {return hand.size();}

  //  public void removeCard(){
  //      hand.set(round.getRoundNumber(),null);
  //  }
    // #TODO
}
