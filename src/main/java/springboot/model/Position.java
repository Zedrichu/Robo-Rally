package springboot.model;

import java.util.Objects;

/**
 * Model class denoting the position in a 2D space.
 */
public class Position {
    public int x;
    public int y;

    /**
     * Class constructor based on integer coordinates.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return (x+1)+":"+(y+1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
