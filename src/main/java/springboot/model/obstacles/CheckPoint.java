package springboot.model.obstacles;

import springboot.model.players.Player;
import java.util.Objects;

/**
 * Inheriting model class denoting the CheckPoint obstacle
 */
public class CheckPoint extends Obstacle {

    private int ID;
    private static int IDs = 0;

    public int getID(){
        return this.ID;
    }

    /**
     * Class constructor
     */
    public CheckPoint(){
        IDs++;
        this.ID = IDs;
    }

    /**
     * Implementation of the abstract method of obstacle
     * @param player - Player object to collect check-point
     */
    @Override
    public void applyDamage(Player player, int damage) {
        player.addCheckPoint(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckPoint that = (CheckPoint) o;
        return getID() == that.getID();
    }
}
