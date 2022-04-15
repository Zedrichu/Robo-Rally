package springboot.model.cards;

import org.junit.jupiter.api.Test;
import springboot.model.Direction;
import springboot.model.Position;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void applyAction() {
        Card c1 = new MovingCard(2);
        Card c2 = new RotatingCard(90);
        assertEquals(c1.getName(),"Move2Forward");
        assertNotEquals(c1, c2);
        Card c3 = new MovingCard(2);
        assertNotEquals(c1, c3);
    }

}