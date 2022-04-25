package springboot.model;

import java.util.Objects;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + (x+1) +
                ", y=" + (y+1) +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
