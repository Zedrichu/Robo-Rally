package springboot.model.obstacles;
import springboot.model.obstacles.Obstacle;
import springboot.model.players.Player;

import java.util.Objects;

// individual checkpoints (objects)
public class CheckPoint extends Obstacle {

    private int ID;
    private static int IDs=0;

    public int getID(){
        IDs++;
        return this.ID;
    }

    public CheckPoint(){
        this.ID = getID();
    }

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
