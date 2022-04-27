package springboot.model.board;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testPlayer() {
        Board b = new Board(10, 10);
        assertEquals(b.getCols(), 10);
        assertEquals(b.getRows(), 10);

        assertTrue(Arrays.deepEquals(b.getBoard(), new Board(10, 10).getBoard()));
    }

}