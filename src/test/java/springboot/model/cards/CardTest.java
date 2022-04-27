package springboot.model.cards;

import org.junit.jupiter.api.Test;
import springboot.model.Direction;
import springboot.model.Position;


import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void applyAction() {

        Card c1 = CardFactory.getCard(CardType.MOVE, 2);
        Card c2 = CardFactory.getCard(CardType.ROTATE, 2);
        assertEquals(c1.getName(),"Move2Forward");
        assertNotEquals(c1, c2);
        Card c3 = new MovingCard(2);
        assertNotEquals(c1, c3);

        c1.setName("cardOne");
        assertTrue(c1.getName() == "cardOne");

        assertTrue(c1.equals(c1));

        assertTrue((CardFactory.getCard(CardType.MOVE, 2).getClass()).equals(c1.getClass()));
        assertTrue((CardFactory.getCard(CardType.ROTATE, 2).getClass()).equals(c2.getClass()));


    }

}