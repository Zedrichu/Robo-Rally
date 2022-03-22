package game.cards;

import java.util.ArrayList;
import java.util.Set;

//interface Card {
 //   public void action();
//}

public enum CardAction{
    MOVEUP(3);
    MOVEUPTWO(2)
    MOVEUPTHREE(3)
    MOVEBACK(-1)
    ROTATELEFT(1)
    ROTATERIGHT(1)
    UTURN(2)

    private int value;

    private CardValue(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}

public class Deck {
    private ArrayList deck;

    public Deck(CardValue value) {
        this.deck = new ArrayList();
        for (int i = 0; i <= 84; i++) {
            if (i <= 18) {
                CardValue value = CardValue.values(1)[i];
            } else if (i > 18 && i <= 30) {
                CardValue value = CardValue.values(2)[i];
            } else if (i > 30 && i <= 36) {
                CardValue value = CardValue.values(3)[i];
            } else if (i > 36 && i <= 54) {
                CardValue value = CardValue.values(1)[i];
            } else if (i > 54 && i <= 72) {
                CardValue value = CardValue.values(1)[i];
            } else if (i > 72 && i <= 78) {
                CardValue value = CardValue.values(2)[i];
            } else if (i > 78 && i <= 84) {
                CardValue value = CardValue.values(-1)[i];
            }
        }
        Collections.shuffle(deck);

        Iterator cardIterator = deck.iterator();
        while (cardIterator.hasNext()) {
            Card aCard = cardIterator.next();
            System.out.println(aCard.getCardValue());
        }

    }
}


public class Card
{
    private CardValue cardValue;

    public Card (CardValue cardValue)
    {
        this.cardValue = cardValue;
    }

    public CardValue getCard()
    {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue)
    {
        this.cardValue = cardValue;
    }
}



