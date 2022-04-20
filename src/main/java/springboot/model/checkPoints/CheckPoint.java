package springboot.model.checkPoints;

import springboot.model.Position;

// individual checkpoints (objects)
public class CheckPoint {
    int ID;
    private static int IDs=0;
    private Position position;
    int x;
    int y;

    public int getID(){
        IDs++;
        return IDs;
    }

    public CheckPoint(){
        this.ID = getID();
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }
}
